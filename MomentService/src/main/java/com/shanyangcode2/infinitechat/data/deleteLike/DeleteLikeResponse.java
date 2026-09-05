package com.shanyangcode2.infinitechat.data.deleteLike;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeleteLikeResponse {
    /**
     * 操作结果消息
     */
    private String message;
}