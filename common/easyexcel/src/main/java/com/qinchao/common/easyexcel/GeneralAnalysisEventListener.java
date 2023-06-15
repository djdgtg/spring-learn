package com.qinchao.common.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
public class GeneralAnalysisEventListener<T> extends AnalysisEventListener<T> {

    private final Consumer<List<T>> dataConsumer;
    private final Consumer<List<ExcelCheckMessage>> errorConsumer;
    private final List<T> data = new ArrayList<>();
    private final List<ExcelCheckMessage> error = new ArrayList<>();

    public GeneralAnalysisEventListener(Consumer<List<T>> dataConsumer, Consumer<List<ExcelCheckMessage>> errorConsumer) {
        this.dataConsumer = dataConsumer;
        this.errorConsumer = errorConsumer;
    }

    // 一行一行读取 excel 内容
    @Override
    public void invoke(T excelData, AnalysisContext analysisContext) {
        Integer rowIndex = analysisContext.readRowHolder().getRowIndex() + 1;
        ExcelCheckMessage message = ExcelUtils.checkData(excelData, rowIndex);
        if (message == null) {
            data.add(excelData);
        } else {
            error.add(message);
        }
    }

    // 读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("表头：" + headMap);
    }

    // 读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 全部数据校验通过则插入数据
        if (error.size() == 0) {
            dataConsumer.accept(data);
        } else {
            errorConsumer.accept(error);
        }
    }
}
