package com.qinchao.cms.aspect;

import com.qinchao.cms.entity.BaseLogs;
import com.qinchao.cms.entity.BaseManagers;
import com.qinchao.cms.service.SysLogsService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogsService sysLogsService;

    @Autowired
    private HttpServletRequest request; //自动注入request

    private static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

    @Pointcut("@annotation(com.qinchao.cms.aspect.LogAnnotation)")
    public void actionAspect() {
    }

    @AfterReturning("actionAspect() && @annotation(logAnnotation)")
    public void afterReturn(LogAnnotation logAnnotation) {
        try {
            BaseManagers loginUser = (BaseManagers) request.getSession().getAttribute("USER_VALUE_OBJECT");
            String logtype = logAnnotation.logtype();
            String logdetail = logAnnotation.logdetail();
            if (loginUser != null) {
                BaseLogs log = new BaseLogs();
                log.setLogtype(Integer.valueOf(logtype));
                log.setLogdetail(logdetail);
                log.setCreatetime(new Date());
                log.setCreator(loginUser.getUserid());
                sysLogsService.insert(log);
            }
        } catch (Exception e) {
            logger.error("==后置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }
}
