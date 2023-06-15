package com.qinchao.boot.system.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qinchao.boot.system.bean.ItemVo;
import com.qinchao.boot.system.bean.RemindLater;
import com.qinchao.boot.system.service.WsService;
import com.qinchao.boot.system.util.FreemarkerUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;

/**
 * Description
 *
 * @author djdgt
 * @since 2023/5/8 17:23
 */
@RestController
@RequestMapping("tools")
@Slf4j
public class ToolsController {

    private final ThreadPoolTaskExecutor executor;
    private final WsService wsService;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final JavaMailSender javaMailSender;

    @Value("${sms.sendUrl}")
    private String smsSendUrl;
    @Value("${sms.key}")
    private String smsKey;

    @Value("${spring.mail.username}")
    private String sendMailer;

    public ToolsController(ThreadPoolTaskExecutor executor, WsService wsService, RestTemplate restTemplate, ObjectMapper objectMapper, JavaMailSender javaMailSender) {
        this.executor = executor;
        this.wsService = wsService;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.javaMailSender = javaMailSender;
    }

    @GetMapping("base64/encode")
    private String base64Encode(String content) {
        return Base64Utils.encodeToString(content.getBytes(StandardCharsets.UTF_8));
    }

    @GetMapping("base64/decode")
    private String base64Decode(String content) {
        return new String(Base64Utils.decodeFromString(content));
    }

    @GetMapping("remindLater/{id}")
    private Long remindLater(@PathVariable Long id) {
        log.info("延迟开始...");
        log.info("[{}]设为延迟", id);
        ItemVo<Long> itemVoTb = new ItemVo<>(1000 * 10, id);
        // 创建延迟队列
        DelayQueue<ItemVo<Long>> queue = new DelayQueue<>();
        // 将业务类放入延迟队列
        queue.offer(itemVoTb);
        // 将任务提交线程池
        executor.execute(new RemindLater(queue));
        return id;
    }

    @GetMapping("wsSend/{message}")
    private String wsSend(@PathVariable String message) throws IOException {
        wsService.broadcastMsg(message);
        return message;
    }

    @GetMapping("md5")
    private String md5(String content) {
        return DigestUtils.md5DigestAsHex((content).getBytes());
    }

    @GetMapping("rest")
    private String rest() throws JsonProcessingException {
        Map<String, Object> data = new HashMap<>();
        data.put("template", "1");
        data.put("L1", "武汉");
        // 等级
        data.put("L2", 3);
        // 持续时间
        data.put("L3", 2);
        String sendUrl = smsSendUrl + "?action=Sms_Template&userKey=bsjtQxJsc&phone={phone}&Key={key}&content={content}";
        String result = restTemplate.postForObject(sendUrl, null, String.class, "17319174884", smsKey, objectMapper.writeValueAsString(data));
        log.info("sendMessage response: {}", result);
        return result;
    }

    @GetMapping("template")
    private void template(HttpServletResponse response) throws IOException, TemplateException {
        Map<String, Object> data = getData();
        FreemarkerUtils.outPutData(response, "rain.ftl", "rain.doc", data);
    }

    @NotNull
    private static Map<String, Object> getData() throws IOException {
        Map<String, Object> data = new HashMap<>();
        ClassPathResource cpr = new ClassPathResource("/static/img/01-01.png");
        InputStream inputStream = cpr.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        int read = inputStream.read(bytes);
        String method = "1.请提请醒室外作业人员做好作业期间的防风准备。\n" +
                "2.请车站值班员提醒乘务员注意运行。\n" +
                "3.请车站值班员与机车乘务员保持联系，随时掌握区间风力信息。\n" +
                "4.请检查站内广告牌匾、站名标志等易受大风影响的设备固定情况。";
        BASE64Encoder encoder = new BASE64Encoder();
        data.put("warnType", encoder.encode(bytes));
        data.put("warnStandard", "24小时内可能受大风影响,平均风力可达6级以上，或者阵风7级以上；或者已经受大风影响,平均风力为6～7级，或者阵风7～8级并可能持续。");
        data.put("planMethodRail", method.replace("\r\n", "<w:br/>").replace("\n", "<w:br/>"));
        data.put("planMethod", "1.政府及相关部门按照职责做好防大风工作；2.停止露天活动和高空等户外危险作业，危险地带人员和危房居民尽量转到避风场所避风；3.相关水域水上作业和过往船舶采取积极的应对措施，加固港口设施，防止船舶走锚、搁浅和碰撞；4.切断户外危险电源，妥善安置易受大风影响的室外物品，遮盖建筑物资；5.机场、高速公路等单位应当采取保障交通安全的措施，有关部门和单位注意森林、草原等防火。");
        return data;
    }

    @GetMapping("simple/mail")
    private void simpleMail() {
        //创建简单邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //谁发的
        message.setFrom(sendMailer);
        //谁要接收
        message.setTo("519953280@qq.com");
        //邮件标题
        message.setSubject("test标题");
        //邮件内容
        message.setText("test内容。。。");
        javaMailSender.send(message);
        log.info("send end.");
    }

    @GetMapping("template/mail")
    private void mail() throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //发件人，邮箱地址，别名
        helper.setFrom(sendMailer, "Qin Chao");
        helper.setTo("519953280@QQ.COM");
        Map<String, Object> data = new HashMap<>();
        data.put("user", "覃先生");
        Template template = FreemarkerUtils.getTemplate("mail.ftl");
        String emailContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
        helper.setSubject("test freemarker");
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

}
