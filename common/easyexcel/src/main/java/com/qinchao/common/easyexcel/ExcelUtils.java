package com.qinchao.common.easyexcel;

import com.alibaba.excel.EasyExcel;
import lombok.SneakyThrows;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/5/16 9:44
 */
public class ExcelUtils {

    /**
     * @param inputStream   输入流
     * @param dataConsumer  excel转成的list如何处理
     * @param errorConsumer 校验失败的信息如何处理
     * @param headClass     表头
     */
    public static <T> void importData(InputStream inputStream, Consumer<List<T>> dataConsumer,
                                      Consumer<List<ExcelCheckMessage>> errorConsumer, Class<T> headClass) {
        EasyExcel
                .read(inputStream, headClass, new GeneralAnalysisEventListener<>(dataConsumer, errorConsumer))
                .sheet()
                .doRead();
    }

    public static <T> void exportData(File file, List<T> data, Class<T> headClass) {
        EasyExcel.write(file, headClass).sheet().doWrite(data);
    }

    @SneakyThrows
    public static <T> ExcelCheckMessage checkData(T data, Integer rowIndex) {
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            ExcelCheck excelCheck = field.getAnnotation(ExcelCheck.class);
            if (excelCheck != null) {
                Object object = field.get(data);
                if (excelCheck.notEmpty() && object == null) {
                    return ExcelCheckMessage.error(rowIndex, "不能为空");
                }
                if (object != null && object.toString().length() > excelCheck.maxLength()) {
                    return ExcelCheckMessage.error(rowIndex, "长度不能超过" + excelCheck.maxLength());
                }
            }
        }
        return null;
    }
}
