package com.shanyangcode2.infinitechat.data.offlineMessage;

import lombok.Data;

@Data
public class OfflineMessageBody {
    private String content;

    private String createdAt;

    private String replyId;
}
