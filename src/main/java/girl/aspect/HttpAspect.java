package girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

/**
 * Created by cmazxiaoma on 2017/10/29.
 * everyday is mayday.
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger _log = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(* girl.controller..*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        _log.info("url = {}", request.getRequestURL());
        _log.info("method = {}", request.getMethod());
        _log.info("ip = {}", request.getRemoteAddr());
        _log.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        _log.info("args = {}", joinPoint.getArgs());
    }

    @After("pointCut()")
    public void  doAfter() {
        _log.info("after");
    }

    @AfterReturning(returning = "object", pointcut = "pointCut()")
    public void doAtferReturning(Object object) {
        _log.info("response = {}", object);
    }
}
