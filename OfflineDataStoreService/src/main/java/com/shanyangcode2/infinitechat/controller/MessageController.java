package com.shanyangcode2.infinitechat.controller;

import com.shanyangcode2.infinitechat.common.Result;
import com.shanyangcode2.infinitechat.data.offlineMessage.OfflineMessageRequest;
import com.shanyangcode2.infinitechat.data.offlineMessage.OfflineMessageResponse;
import com.shanyangcode2.infinitechat.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/offline")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/message")
    public Result<OfflineMessageResponse> getOfflineMessage(@Valid OfflineMessageRequest offlineMessageRequest)
    {
        OfflineMessageResponse offlineMessageResponse= messageService.getOfflineMessage(offlineMessageRequest);
        return Result.ok(offlineMessageResponse);
    }

}
