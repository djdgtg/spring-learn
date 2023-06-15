package com.qinchao.common.base.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * description: <br/>
 * ThreadLocal工具类
 * 本工具类中ThreadLocal存储的是 Map<String, Object>
 * <br/>
 *
 * @author qc
 * @since 2023/03/24 15:15
 */
public final class ThreadLocalUtils {

    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL =
            ThreadLocal.withInitial(() -> new ConcurrentHashMap<>(16));

    /**
     * 获取到ThreadLocal中值
     *
     * @return ThreadLocal存储的是Map
     */
    public static Map<String, Object> getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    /**
     * 从ThreadLocal中的Map获取值
     *
     * @param key Map中的key
     * @param <T> Map中的value的类型
     * @return Map中的value值 可能为空
     */
    public static <T> T get(String key) {
        return get(key, null);
    }

    /**
     * 从ThreadLocal中的Map获取值
     *
     * @param key          Map中的key
     * @param defaultValue Map中的value的为null 是 的默认值
     * @param <T>          Map中的value的类型
     * @return Map中的value值 可能为空
     */
    public static <T> T get(String key, T defaultValue) {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map.isEmpty()) {
            return null;
        }
        return (T) Optional.ofNullable(map.get(key)).orElse(defaultValue);
    }

    /**
     * ThreadLocal中的Map设置值
     *
     * @param key   Map中的key
     * @param value Map中的value
     */
    public static void set(String key, Object value) {
        Map<String, Object> map = THREAD_LOCAL.get();
        map.put(key, value);
    }

    /**
     * ThreadLocal中的Map 添加Map
     *
     * @param keyValueMap 参数map
     */
    public static void set(Map<String, Object> keyValueMap) {
        Map<String, Object> map = THREAD_LOCAL.get();
        map.putAll(keyValueMap);
    }

    /**
     * 删除ThreadLocal中的Map 中的value
     *
     * @param key Map中的key
     */
    public static void delete(String key) {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map.isEmpty()) {
            return;
        }
        map.remove(key);
    }

    /**
     * 删除ThreadLocal中的Map
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }

    /**
     * 从ThreadLocal中的Map获取值 根据可key的前缀
     *
     * @param prefix key 的前缀
     * @param <T>    Map中的value的类型
     * @return 符合条件的Map
     */
    public static <T> Map<String, T> fetchVarsByPrefix(String prefix) {
        Map<String, T> vars = new HashMap<>(16);
        if (prefix == null || prefix.length() == 0) {
            return vars;
        }
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map.isEmpty()) {
            return vars;
        }
        return map.entrySet().stream().filter(test -> test.getKey().startsWith(prefix))
                .collect(Collectors.toMap(Map.Entry::getKey, time -> (T) time.getValue()));
    }

    /**
     * 删除ThreadLocal中的Map 中的Value  按 Map中的Key的前缀
     *
     * @param prefix Map中的Key的前缀
     */
    public static void deleteVarsByPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return;
        }
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map.isEmpty()) {
            return;
        }
        map.keySet().stream().filter(o -> o.startsWith(prefix)).collect(Collectors.toSet()).forEach(map::remove);
    }
}

