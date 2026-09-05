package com.shanyangcode2.infinitechat.common;

import lombok.Data;

@Data
public class TextMessage extends MessageBody {
    private TextMessageBody body;

    @Override
    public String toString(){
        return super.toString();
    }
}
