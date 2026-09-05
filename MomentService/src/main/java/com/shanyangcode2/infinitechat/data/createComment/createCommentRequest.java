package com.shanyangcode2.infinitechat.data.createComment;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Accessors(chain = true)
public class createCommentRequest {

    private Long momentId;

    private MomentCommentDTO momentCommentDTO;
}
