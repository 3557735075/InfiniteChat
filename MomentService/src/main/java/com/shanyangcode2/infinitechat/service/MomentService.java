package com.shanyangcode2.infinitechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanyangcode2.infinitechat.common.Result;
import com.shanyangcode2.infinitechat.data.createMoment.createMomentRequest;
import com.shanyangcode2.infinitechat.data.createMoment.createMomentResponse;
import com.shanyangcode2.infinitechat.data.deleteMoment.DeleteMomentRequest;
import com.shanyangcode2.infinitechat.data.deleteMoment.DeleteMomentResponse;
import com.shanyangcode2.infinitechat.model.Moment;

public interface MomentService extends IService<Moment> {
     createMomentResponse createMoment(createMomentRequest request) throws Exception;

    Long getMomentOwnerId(Long momentId);
    DeleteMomentResponse deleteMoment(DeleteMomentRequest request);


}
