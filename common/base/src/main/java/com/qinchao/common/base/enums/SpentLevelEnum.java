package com.qinchao.common.base.enums;

import lombok.Getter;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/2/20 10:37
 */
@Getter
public enum SpentLevelEnum {

    EXTREMELY_FAST("extremely_fast", "小于100ms"),
    FAST("extremely_fast", "100到300ms之间"),
    NORMAL("normal", "300到500ms之间"),
    SLOW("slow", "500到1000ms之间"),
    EXTREMELY_SLOW("extremely_slow", "大于1000ms");

    private final String level;
    private final String description;

    SpentLevelEnum(String level, String description) {
        this.level = level;
        this.description = description;
    }

    public static SpentLevelEnum getSpentLevelBySpent(long spent) {
        if (spent <= 100) {
            return EXTREMELY_FAST;
        } else if (spent <= 300) {
            return FAST;
        } else if (spent <= 500) {
            return NORMAL;
        } else if (spent <= 1000) {
            return SLOW;
        } else {
            return EXTREMELY_SLOW;
        }
    }

}
