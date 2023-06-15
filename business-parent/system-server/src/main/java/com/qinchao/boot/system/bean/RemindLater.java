package com.qinchao.boot.system.bean;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;

@Slf4j
@AllArgsConstructor
public class RemindLater implements Runnable {

    /**
     * 使用DelayQueue：一个使用优先级队列实现的无界阻塞队列。
     */
    private final DelayQueue<ItemVo<Long>> queue;

    @Override
    public void run() {
        try {
            ItemVo<Long> take = queue.take();
            Long id = take.getData();
            log.info("[{}]取消延迟", id);
            log.info("开始往web发送消息id={}", id);
            log.info("延迟结束。");
        } catch (InterruptedException e) {
            log.error("稍后提醒的延迟队列出现错误", e);
        }
    }
}
