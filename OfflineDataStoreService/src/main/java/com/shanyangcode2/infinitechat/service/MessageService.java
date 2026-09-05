package com.shanyangcode2.infinitechat.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shanyangcode2.infinitechat.data.offlineMessage.OfflineMessageRequest;
import com.shanyangcode2.infinitechat.data.offlineMessage.OfflineMessageResponse;
import com.shanyangcode2.infinitechat.model.Message;

public interface MessageService extends IService<Message> {    //  这里不用写任何方法，就能用很多数据库操作

    OfflineMessageResponse getOfflineMessage(OfflineMessageRequest request);

    void saveOfflineMessage(String message);
}
