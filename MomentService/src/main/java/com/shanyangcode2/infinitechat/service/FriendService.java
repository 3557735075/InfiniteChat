package com.shanyangcode2.infinitechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanyangcode2.infinitechat.model.Friend;


import java.util.List;

public interface FriendService extends IService<Friend> {
    List<Long> getFriendIds(Long userId);
}