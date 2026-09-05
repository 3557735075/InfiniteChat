package com.shanyangcode.infinitechat.messageingservice.conf;

import com.shanyangcode.infinitechat.messageingservice.common.ServiceException;
import com.shanyangcode.infinitechat.messageingservice.util.PreventDuplicateSubmit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@Aspect
public class PreventDuplicateSubmitAspect {
    private static final String KEY_PREFIX = "prevent-duplicate-submit:";

    private final RedisTemplate<String, Object> redisTemplate;

    public PreventDuplicateSubmitAspect(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(preventDuplicateSubmit)")
    public Object preventDuplicateSubmit(ProceedingJoinPoint joinPoint,
                                         PreventDuplicateSubmit preventDuplicateSubmit) throws Throwable {
        String requestIdentity = joinPoint.getSignature().toShortString()
                + Arrays.deepToString(joinPoint.getArgs());
        String key = KEY_PREFIX + DigestUtils.md5DigestAsHex(
                requestIdentity.getBytes(StandardCharsets.UTF_8));

        Boolean accepted = redisTemplate.opsForValue().setIfAbsent(
                key,
                System.currentTimeMillis(),
                preventDuplicateSubmit.timeout(),
                TimeUnit.MILLISECONDS);
        if (!Boolean.TRUE.equals(accepted)) {
            log.warn("检测到重复提交，key={}", key);
            throw new ServiceException("请勿重复提交");
        }

        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            redisTemplate.delete(key);
            throw throwable;
        }
    }
}
