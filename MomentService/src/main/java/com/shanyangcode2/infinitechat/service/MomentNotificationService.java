package com.shanyangcode2.infinitechat.service;

import com.shanyangcode2.infinitechat.data.createMoment.createMomentRequest;
import com.shanyangcode2.infinitechat.data.createMoment.createMomentResponse;
import com.shanyangcode2.infinitechat.data.deleteMoment.DeleteMomentRequest;
import com.shanyangcode2.infinitechat.data.deleteMoment.DeleteMomentResponse;

import java.util.List;

public interface MomentNotificationService {

    /**
     * 发送朋友圈创建通知
     *
     * @param senderUserId 发送者用户ID
     * @param momentId 朋友圈ID
     * @param receiverUserIds 接收者用户ID列表

     * @throws Exception 发送通知过程中可能发生的异常
     */
    void sendMomentCreationNotification(Long senderUserId,String avator, Long momentId, List<Long> receiverUserIds) throws Exception;

    /**
     * 发送朋友圈点赞或评论通知
     *
     * @param senderUserId 发送者用户ID
     * @param momentId 朋友圈ID
     * @param receiverUserIds 接收者用户ID列表
     * @throws Exception 发送通知过程中可能发生的异常
     */
    void sendInteractionNotification(Long senderUserId,Long momentId, List<Long> receiverUserIds) throws Exception;
}