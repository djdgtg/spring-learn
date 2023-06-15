package com.qinchao.boot.system.bean;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ItemVo<T> implements Delayed {

    /**
     * 到期时间 单位：ms
     */
    private final long activeTime;
    /**
     * 实体（使用泛型是因为后续扩展其他业务共用此业务类）
     */
    private final T data;

    public ItemVo(long activeTime, T data) {
        // 将传入的时间转换为超时的时刻
        this.activeTime = TimeUnit.NANOSECONDS.convert(activeTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        this.data = data;
    }

    public long getActiveTime() {
        return activeTime;
    }

    public T getData() {
        return data;
    }

    /**
     * 按照剩余时间进行排序
     *
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Delayed o) {
        // 订单剩余时间-当前传入的时间= 实际剩余时间（单位纳秒）
        long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        // 根据剩余时间判断等于0 返回1 不等于0
        // 有可能大于0 有可能小于0  大于0返回1  小于返回-1
        return (d == 0) ? 0 : ((d > 0) ? 1 : -1);
    }

    /**
     * 获取剩余时间
     *
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        // 剩余时间= 到期时间-当前系统时间，系统一般是纳秒级的，所以这里做一次转换
        return unit.convert(activeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }
}
