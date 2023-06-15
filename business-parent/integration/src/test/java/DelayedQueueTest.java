import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * description: 延时队列测试
 *
 * @author hh
 */
@Slf4j
public class DelayedQueueTest {

    public static void main(String[] args) throws InterruptedException {
        Item item1 = new Item("item1", 5, TimeUnit.SECONDS);
        Item item2 = new Item("item2", 10, TimeUnit.SECONDS);
        Item item3 = new Item("item3", 15, TimeUnit.SECONDS);
        DelayQueue<Item> queue = new DelayQueue<>();
        queue.put(item1);
        queue.put(item2);
        queue.put(item3);
        log.info("begin time:" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        for (int i = 0; i < 3; i++) {
            Item take = queue.take();
            log.info("name:{}, time:{}", take.name, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        }
    }

}

