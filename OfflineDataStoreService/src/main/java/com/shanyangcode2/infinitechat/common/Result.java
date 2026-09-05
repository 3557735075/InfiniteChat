package com.shanyangcode2.infinitechat.common;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@Accessors(chain = true)
public class Result<T> {
    private int code;
    private String message;
    private T data;
    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
    public static <T> Result<T> ok(T data){
        Result<T> r = new Result<>();
        return r.setCode(HttpStatus.OK.value()).setData(data);
    }

}
