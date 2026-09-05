package com.shanyangcode2.infinitechat.data.offlineMessage;

import lombok.Data;

@Data
public class OfflineMessageDetail {
    private String avatar;

    private OfflineMessageBody offlineMessageBody;

    private Integer type;

    private String userName;

    private String sendUserId;

    private String messageId;
}
