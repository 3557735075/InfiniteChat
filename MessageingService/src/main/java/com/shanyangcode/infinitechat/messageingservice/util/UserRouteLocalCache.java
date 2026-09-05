package com.shanyangcode.infinitechat.messageingservice.util;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import java.time.Duration;
@Component
public class UserRouteLocalCache {
    private final Cache<String, String> userRouteCache;

    public UserRouteLocalCache() {
        userRouteCache = Caffeine.newBuilder()
                .expireAfterWrite(Duration.ofMinutes(30))
                .maximumSize(1000)
                .build();
    }

    // 查询缓存
    public String getIfPresent(String userId) {
        return userRouteCache.getIfPresent(userId);
    }

    // 写入缓存
    public void put(String userId, String rtcServerAddr) {
        userRouteCache.put(userId, rtcServerAddr);
    }

    // 清除指定用户缓存（核心：invalidate）
    public void invalidate(String userId) {
        userRouteCache.invalidate(userId);
    }
}
