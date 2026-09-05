package com.shanyangcode2.infinitechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanyangcode2.infinitechat.data.createComment.createCommentRequest;
import com.shanyangcode2.infinitechat.data.createComment.createCommentResponse;
import com.shanyangcode2.infinitechat.model.MomentComment;

public interface MomentCommentService extends IService<MomentComment> {
    createCommentResponse createComment(createCommentRequest request) throws Exception;
}
