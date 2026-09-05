package com.shanyangcode2.infinitechat.common;

import lombok.Data;

@Data
public class TextMessageBody {
    private String content;
    private Long replyId;
}
