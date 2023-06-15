package com.qinchao.common.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/5/16 10:44
 */
@Getter
@Setter
@AllArgsConstructor
public class ExcelCheckMessage {

    @ExcelProperty(value = "行号")
    private Integer rowIndex;

    @ExcelProperty(value = "错误信息")
    private String errorMessage;

    public static ExcelCheckMessage error(Integer rowIndex, String errorMessage) {
        return new ExcelCheckMessage(rowIndex, errorMessage);
    }
}
