package com.shanyangcode2.infinitechat.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shanyangcode2.infinitechat.mappeer.UserMapper;
import com.shanyangcode2.infinitechat.model.User;
import com.shanyangcode2.infinitechat.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Zzw
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-10-08 16:08:49
 */
@Service
@SuppressWarnings({"all"})
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}