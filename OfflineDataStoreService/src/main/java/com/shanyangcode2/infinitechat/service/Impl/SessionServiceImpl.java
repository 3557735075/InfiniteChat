package com.shanyangcode2.infinitechat.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanyangcode2.infinitechat.mappeer.SessionMapper;
import com.shanyangcode2.infinitechat.model.Session;
import com.shanyangcode2.infinitechat.service.SessionService;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl extends ServiceImpl<SessionMapper, Session>  //继承 ServiceImpl 后，增删改查的 SQL 都帮你写好了，直接调用方法就行
        implements SessionService {

}