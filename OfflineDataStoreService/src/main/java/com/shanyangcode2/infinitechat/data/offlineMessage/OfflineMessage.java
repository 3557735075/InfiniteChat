package com.shanyangcode2.infinitechat.data.offlineMessage;

import lombok.Data;

import java.util.List;
@Data
public class OfflineMessage {
    private Long total;

    private String sessionId;

    private String sessionName;

    private String sessionAvatar;

    private Integer sessionType;

    private List<OfflineMessageDetail> offlineMessageDetails;
}
