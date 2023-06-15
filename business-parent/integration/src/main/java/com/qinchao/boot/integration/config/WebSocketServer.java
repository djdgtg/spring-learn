package com.qinchao.boot.integration.config;

import com.qinchao.boot.integration.entity.SysUser;
import com.qinchao.boot.integration.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@Component
@Slf4j
@Service
@ServerEndpoint("/ws/{userId}")
public class WebSocketServer {

    private static SysUserService sysUserService;

    @Autowired
    public void setUserMapper(SysUserService sysUserService) {
        WebSocketServer.sysUserService = sysUserService;
    }

    //静态变量，用来记录当前在线连接数
    private final static AtomicInteger count = new AtomicInteger(0);
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private final static Map<String, Session> webSocketMap = new ConcurrentHashMap<>();

    //接收sid
    private String userId;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.userId = userId;
        webSocketMap.put(userId, session);     //加入set中
        SysUser sysUser = sysUserService.getById(Integer.valueOf(userId));
        addOnlineCount();           //在线数加1
        try {
            sendMessage(session, "connect success");
            log.info("有新窗口开始监听: {}, 用户名:{}, 当前在线人数为: {}", userId, sysUser.getRealName(), getOnlineCount());
        } catch (IOException e) {
            log.error("websocket IO Exception");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketMap.remove(userId);
        subOnlineCount();           //在线数减1
        //断开连接情况下，更新主板占用情况为释放
        log.info("释放的userId为：" + userId);
        //这里写你 释放的时候，要处理的业务
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());

    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自窗口" + userId + "的信息:" + message);
    }

    /**
     * @ Param session
     * @ Param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误", error);
    }

    /**
     * 实现服务器主动推送
     */
    public static void sendMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, String toUserId) throws IOException {
        if (StringUtils.hasLength(toUserId)) {
            Session session = webSocketMap.get(toUserId);
            if (session != null) {
                sendMessage(session, message);
            }
        } else {
            for (Session session : webSocketMap.values()) {
                sendMessage(session, message);
            }
        }
    }

    public static int getOnlineCount() {
        return count.get();
    }

    public static void addOnlineCount() {
        count.getAndIncrement();
    }

    public static void subOnlineCount() {
        count.getAndDecrement();
    }

}
