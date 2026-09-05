package com.shanyangcode2.infinitechat.data.offlineMessage;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
@Data
@Accessors(chain = true)
public class OfflineMessageRequest {
    @NotEmpty(message = "User ID cannot be empty")
    private Long userId;
    @NotEmpty(message = "时间不能为空")
    private String time;

}