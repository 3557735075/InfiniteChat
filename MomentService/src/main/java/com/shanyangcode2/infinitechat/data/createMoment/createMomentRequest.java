package com.shanyangcode2.infinitechat.data.createMoment;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Accessors(chain = true)
public class createMomentRequest {
    @NotEmpty(message = "用户id不能为空")
    private String userID;

    private String text;

    private List<String> mediaUrls;
}
