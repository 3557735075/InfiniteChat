package com.shanyangcode.infinitechat.messageingservice.util;

import com.shanyangcode.infinitechat.messageingservice.constants.RedPacketConstants;
import com.shanyangcode.infinitechat.messageingservice.service.GetRedPacketService;
import com.shanyangcode.infinitechat.messageingservice.service.RedPacketReceiveService;
import com.shanyangcode.infinitechat.messageingservice.service.RedPacketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedpacketExpireListener implements MessageListener {
    @Autowired
  private RedPacketService redPacketService;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expirekey = message.toString();
        log.info("过期的key"+expirekey);
        if (expirekey.startsWith(RedPacketConstants.RED_PACKET_KEY_PREFIX.getValue())) {
            String substring = expirekey.substring(RedPacketConstants.RED_PACKET_KEY_PREFIX.getValue().length());
            long redPackedID = Long.parseLong(substring);
            log.info("过期红包id" + redPackedID);


            try {
                redPacketService.handleExpiredRedPacket(redPackedID);
            } catch (Exception e) {
                    throw new RuntimeException(e);
            }
        }
    }
}
