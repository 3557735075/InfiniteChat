package com.shanyangcode2.infinitechat.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanyangcode2.infinitechat.Exception.DatabaseException;
import com.shanyangcode2.infinitechat.constants.ConfigEnum;
import com.shanyangcode2.infinitechat.constants.MomentConstants;
import com.shanyangcode2.infinitechat.data.createComment.MomentCommentDTO;
import com.shanyangcode2.infinitechat.data.createComment.MomentCommentVO;
import com.shanyangcode2.infinitechat.data.createComment.createCommentRequest;
import com.shanyangcode2.infinitechat.data.createComment.createCommentResponse;
import com.shanyangcode2.infinitechat.mapper.MomentCommentMapper;
import com.shanyangcode2.infinitechat.model.MomentComment;
import com.shanyangcode2.infinitechat.model.User;
import com.shanyangcode2.infinitechat.service.MomentCommentService;
import com.shanyangcode2.infinitechat.service.MomentNotificationService;
import com.shanyangcode2.infinitechat.service.MomentService;
import com.shanyangcode2.infinitechat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Slf4j
public class MomentCommentServiceImpl extends ServiceImpl<MomentCommentMapper, MomentComment> implements MomentCommentService {
    @Autowired
    @Lazy  // 使用延迟加载避免循环依赖
    private MomentService momentService;
    @Autowired
private UserService userService;
    @Autowired
    private MomentNotificationService notificationService;    @Override
    public createCommentResponse createComment(createCommentRequest request) throws Exception {
        MomentCommentVO momentCommentVO = createCommentWithNotification(request.getMomentId(), request.getMomentCommentDTO());
        createCommentResponse response = new createCommentResponse();
        BeanUtils.copyProperties(momentCommentVO, response);

        return response;

    }




    @Transactional(rollbackFor = Exception.class)
    public MomentCommentVO createCommentWithNotification(Long momentId, MomentCommentDTO momentCommentDTO) throws Exception {
        MomentCommentVO commentVO = createComment(momentId, momentCommentDTO);

        Long momentOwnerId = momentService.getMomentOwnerId(momentId);
        ArrayList<Long> receiveIds = new ArrayList<>();

        if (momentOwnerId != null && !momentOwnerId.equals(momentCommentDTO.getUserId())){
            receiveIds.add(momentOwnerId);

            notificationService.sendInteractionNotification(momentCommentDTO.getUserId(), momentId, receiveIds);
        }

        return commentVO;
            }


    public MomentCommentVO createComment(Long momentId, MomentCommentDTO momentCommentDTO){
        MomentComment momentComment = createMomentComment(momentId, momentCommentDTO);
        boolean save = this.save(momentComment);

        if(!save){
            log.error("评论保存失败：朋友圈ID: {}, 用户ID: {}", momentId, momentCommentDTO.getUserId());
            throw new DatabaseException("评论保存失败");
        }

        return buildCommentVO(momentComment, momentCommentDTO);
    }
    private MomentComment createMomentComment(Long momentId, MomentCommentDTO momentCommentDTO){
        MomentComment momentComment = new MomentComment();
        Snowflake snowflake = IdUtil.getSnowflake(
                Integer.parseInt(ConfigEnum.WORKED_ID.getValue()),
                Integer.parseInt(ConfigEnum.DATACENTER_ID.getValue())
        );

        momentComment.setCommentId(snowflake.nextId());
        momentComment.setComment(momentCommentDTO.getComment());
        momentComment.setMomentId(momentId);
        momentComment.setUserId(momentCommentDTO.getUserId());
        momentComment.setIsDelete(MomentConstants.NOT_DELETED);

        // 设置父评论ID（如果有）
        if (momentCommentDTO.getParentCommentId() != null) {
            momentComment.setParentCommentId(momentCommentDTO.getParentCommentId());
        }

        return momentComment;
    }
    private MomentCommentVO buildCommentVO(MomentComment momentComment, MomentCommentDTO commentDTO){
        MomentCommentVO momentCommentVO = new MomentCommentVO();
        BeanUtils.copyProperties(momentComment, momentCommentVO);

        User user = userService.getById(commentDTO.getUserId());
        momentCommentVO.setUserName(user.getUserName());

        // 设置父评论信息（如果有）
        if (commentDTO.getParentCommentId() != null) {
            setParentCommentInfo(commentDTO.getParentCommentId(), momentCommentVO);
        }

        return momentCommentVO;
    }
    private void setParentCommentInfo(Long parentCommentId, MomentCommentVO commentVO) {
        MomentComment parentComment = this.getById(parentCommentId);
        if (parentComment != null) {
            Long parentUserId = parentComment.getUserId();
            User parentUser = userService.getById(parentUserId);

            commentVO.setParentUserName(parentUser.getUserName());
            commentVO.setParentCommentId(parentComment.getCommentId());
        }
    }


}

