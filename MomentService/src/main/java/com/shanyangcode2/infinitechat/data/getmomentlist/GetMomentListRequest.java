package com.shanyangcode2.infinitechat.data.getmomentlist;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@Accessors(chain = true)
public class GetMomentListRequest {
    @NotNull(message = "用户id不能为空")
    private Long userId;
    @NotNull(message = "时间参数不能为空")
    private String time;
}
