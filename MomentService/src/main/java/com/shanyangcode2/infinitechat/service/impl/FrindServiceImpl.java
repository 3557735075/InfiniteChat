package com.shanyangcode2.infinitechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanyangcode2.infinitechat.mapper.FriendMapper;
import com.shanyangcode2.infinitechat.model.Friend;
import com.shanyangcode2.infinitechat.service.FriendService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FrindServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {
    @Override
    public List<Long> getFriendIds(Long userId) {
       QueryWrapper<Friend> queryWrapper=new QueryWrapper<>();
       queryWrapper.eq("user_id",userId);
       List<Friend> friends=this.list(queryWrapper);
       List<Long> friendids=friends.stream().map(Friend::getFriendId).collect(Collectors.toList());
       return friendids;
    }
}
