package com.qinchao.common.logging.logback.logstash;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import net.logstash.logback.appender.LogstashTcpSocketAppender;
import net.logstash.logback.encoder.LogstashEncoder;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class LogstashAppender implements ApplicationRunner {

    @Value("${spring.application.name}")
    private String service;

    @Value("${logstash.url}")
    private String logstashUrl;

    @Override
    public void run(ApplicationArguments args) {
        LoggerContext lc = (LoggerContext) StaticLoggerBinder.getSingleton().getLoggerFactory();
        LogstashEncoder encoder = new LogstashEncoder();
        encoder.setCustomFields("{\"service\":\"" + service + "\"}");
        encoder.addIncludeMdcKeyName("spent_ms");

        LogstashTcpSocketAppender lsa = new LogstashTcpSocketAppender();
        lsa.setContext(lc);
        lsa.addDestination(logstashUrl);
        lsa.setEncoder(encoder);
        lsa.setName("LOGSTASH");
        lsa.start();

        Logger rootLogger = lc.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.addAppender(lsa);
    }
}
