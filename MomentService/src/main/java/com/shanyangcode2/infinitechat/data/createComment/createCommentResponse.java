package com.shanyangcode2.infinitechat.data.createComment;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class createCommentResponse {
    private Long parentCommentId;

    private String parentUserName;

    private Long commentId;

    private String userName;

    private String comment;
}
