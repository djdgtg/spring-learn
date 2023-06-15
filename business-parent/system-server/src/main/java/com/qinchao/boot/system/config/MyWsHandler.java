package com.qinchao.boot.system.config;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * ws消息处理类
 */
@Component
@Slf4j
public class MyWsHandler extends AbstractWebSocketHandler {

    @Override
    public void afterConnectionEstablished(@NotNull WebSocketSession session) {
        Object userId = session.getAttributes().get("userId");
        log.info("建立ws连接，userId：{}", userId);
        WsSessionManager.add(session.getId(), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("发送文本消息");
        // 获得客户端传来的消息
        String payload = message.getPayload();
        log.info("server 接收到消息 " + payload);
        session.sendMessage(new TextMessage("server 发送给的消息 " + payload + "，发送时间:" + LocalDateTime.now()));
    }

    @Override
    protected void handleBinaryMessage(@NotNull WebSocketSession session, @NotNull BinaryMessage message) {
        log.info("发送二进制消息");
    }

    @Override
    public void handleTransportError(WebSocketSession session, @NotNull Throwable exception) throws IOException {
        log.error("异常处理");
        WsSessionManager.removeAndClose(session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, @NotNull CloseStatus status) throws IOException {
        log.info("关闭ws连接");
        WsSessionManager.removeAndClose(session.getId());
    }
}
