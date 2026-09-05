package com.shanyangcode2.infinitechat.consumer;

import com.shanyangcode2.infinitechat.constants.kafka.kafkaconstants;
import com.shanyangcode2.infinitechat.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service      //将当前类注册为 Spring Bean，交给容器管理，可使用@Autowired注入，专门用于业务 / 消费者服务层。
@Slf4j
@RequiredArgsConstructor       //自动生成仅包含 final 修饰字段的构造方法，实现构造注入，替代@Autowired：

public class MessageConsumer {
    @Autowired
    private MessageService messageService;

    @KafkaListener(topics = kafkaconstants.topic, groupId = kafkaconstants.consumerGroupId)
    public void listen(String message){
        messageService.saveOfflineMessage(message);
    }
}