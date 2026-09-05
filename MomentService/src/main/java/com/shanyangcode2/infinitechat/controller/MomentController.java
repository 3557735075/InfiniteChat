package com.shanyangcode2.infinitechat.controller;


import com.shanyangcode2.infinitechat.common.Result;
import com.shanyangcode2.infinitechat.data.createComment.MomentCommentDTO;
import com.shanyangcode2.infinitechat.data.createComment.createCommentRequest;
import com.shanyangcode2.infinitechat.data.createComment.createCommentResponse;
import com.shanyangcode2.infinitechat.data.createLike.CreateLikeRequest;
import com.shanyangcode2.infinitechat.data.createLike.CreateLikeResponse;
import com.shanyangcode2.infinitechat.data.createMoment.createMomentRequest;
import com.shanyangcode2.infinitechat.data.createMoment.createMomentResponse;
import com.shanyangcode2.infinitechat.data.deleteLike.DeleteLikeRequest;
import com.shanyangcode2.infinitechat.data.deleteLike.DeleteLikeResponse;
import com.shanyangcode2.infinitechat.data.deleteMoment.DeleteMomentRequest;
import com.shanyangcode2.infinitechat.data.deleteMoment.DeleteMomentResponse;
import com.shanyangcode2.infinitechat.data.getmomentlist.GetMomentListRequest;
import com.shanyangcode2.infinitechat.data.getmomentlist.GetMomentListResponse;
import com.shanyangcode2.infinitechat.model.MomentLike;
import com.shanyangcode2.infinitechat.service.MomentCommentService;
import com.shanyangcode2.infinitechat.service.MomentLikeService;
import com.shanyangcode2.infinitechat.service.MomentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/api/v1/moment")
@RequiredArgsConstructor

public class MomentController {
    @Autowired
    private MomentService momentService;
    @Autowired
    private MomentLikeService momentLikeService;
    @Autowired
    private MomentCommentService momentCommentService;
    @PostMapping("/")
    public Result<createMomentResponse> createMoment(@Valid @RequestBody createMomentRequest request) throws Exception {
        createMomentResponse responseresult= momentService.createMoment(request);
        return Result.OK(responseresult);
    }
    @PostMapping("/like/{momentId}")
    public Result<CreateLikeResponse> likeMoment(@PathVariable Long momentId, @Valid @RequestBody CreateLikeRequest request) throws Exception {
        CreateLikeResponse response = momentLikeService.likeMomentResponse(momentId, request);

        return Result.OK(response);
    }
    @DeleteMapping("/{momentId}")
    public Result<DeleteMomentResponse> deleteMoment(@Valid @ModelAttribute DeleteMomentRequest request) {
        DeleteMomentResponse response = momentService.deleteMoment(request);

        return Result.OK(response);
    }
    @PostMapping("/comment/{momentId}")
    public Result<createCommentResponse> createMoment(
            @NotNull(message = "朋友圈 ID 不能为空") @PathVariable("momentId") Long momentId,
            @Valid @RequestBody MomentCommentDTO momentCommentDTO) throws Exception {
        createCommentRequest request = new createCommentRequest()
                .setMomentId(momentId)
                .setMomentCommentDTO(momentCommentDTO);


        createCommentResponse response = momentCommentService.createComment(request);

        return Result.OK(response);
    }

    @DeleteMapping("/like/{momentId}")
    public Result<DeleteLikeResponse> deleteLikeMoment(@Valid @ModelAttribute DeleteLikeRequest request) {
        // 请求参数自动封装进user对象
        DeleteLikeResponse response = momentLikeService.deleteLikeMoment(request);

        return Result.OK(response);
    }
    @GetMapping("/list/{momentId}")
    public Result<GetMomentListResponse> getMomentList(@Valid @ModelAttribute GetMomentListRequest request) {
        GetMomentListResponse response = momentService.getMomentList(request);

        return Result.OK(response);
    }

}
