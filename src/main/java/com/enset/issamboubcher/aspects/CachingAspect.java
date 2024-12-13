package com.enset.issamboubcher.aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CachingAspect {

    private final Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(Cacheable)")
    public Object handleCaching(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        if (cache.containsKey(key)) {
            System.out.println("Cache hit for " + key);
            return cache.get(key);
        }
        System.out.println("Cache miss for " + key);
        Object result = joinPoint.proceed(); // Proceed with the method
        cache.put(key, result);
        return result;
    }
}
