package ru.gb.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
@RequiredArgsConstructor
public class LoggingAspect {

    private final LoggingProperties properties;

    @Pointcut("@annotation(ru.gb.logging.Logging)")
    public void serviceMethodsPointcut() {
    }

    @Before(value = "serviceMethodsPointcut()")
    public void beforeServiceMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        StringBuilder logMessage = new StringBuilder("Before -> ")
                .append(jp.getTarget().getClass().getSimpleName())
                .append("#")
                .append(methodName)
                .append("(");

        if (properties.isPrintArgs()) {
            Object[] args = jp.getArgs();
            for (int i = 0; i < args.length; i++) {
                if (i > 0) {
                    logMessage.append(", ");
                }
                logMessage.append(args[i].getClass().getSimpleName())
                        .append(" = ")
                        .append(args[i]);
            }
        }

        logMessage.append(")");

        log.atLevel(properties.getLevel()).log(logMessage.toString());
    }
}
