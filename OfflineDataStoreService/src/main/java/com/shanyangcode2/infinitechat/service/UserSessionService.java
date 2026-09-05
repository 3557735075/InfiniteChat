package com.shanyangcode2.infinitechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanyangcode2.infinitechat.model.UserSession;

import java.util.Set;

public interface UserSessionService extends IService<UserSession> {
    Set<Long> findSessionIdByUserId(Long userId);

}
