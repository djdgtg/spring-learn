package com.qinchao.boot.system.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Description: Word导出工具类
 *
 * @author qc
 * @see 2023年2月24日
 */
public class FreemarkerUtils {
    public static void wordCreate(Map<String, Object> dataMap, String fileName, String ftlName, OutputStream outputStream) throws IOException, TemplateException {
        //获取模板
        Template template = getTemplate(ftlName);
        //将模板和数据模型合并生成文件
        Writer out = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        //生成文件
        template.process(dataMap, out);
        //关闭流
        out.flush();
        out.close();
    }

    public static Template getTemplate(String ftlName) throws IOException {
        //创建配置实例
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //设置编码
        configuration.setDefaultEncoding("UTF-8");
        //html或ftl模板文件统一放置html或ftl包下
        configuration.setClassForTemplateLoading(FreemarkerUtils.class, "/templates/");
        //获取模板
        return configuration.getTemplate(ftlName);
    }

    public static void outPutData(HttpServletResponse response, String ftlName, String outFileName, Map<String, Object> dataMap) throws IOException, TemplateException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/msword");
        response.addHeader("Content-Disposition", "attachment;filename=" + outFileName);
        OutputStream out = response.getOutputStream();
        wordCreate(dataMap, outFileName, ftlName, out);
    }
}
