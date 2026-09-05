package com.shanyangcode2.infinitechat.Exception;


import com.shanyangcode2.infinitechat.constants.ErrorEnum;
import lombok.Getter;

@Getter
public class CodeException extends RuntimeException {
    private final int code;

    public CodeException(String message){
        super(message);

        this.code = ErrorEnum.SUCCESS.getCode();

    }

    public CodeException(ErrorEnum errorEnum){
        super(errorEnum.getMessage());

        this.code = errorEnum.getCode();

    }

    public CodeException(ErrorEnum errorEnum, String message){
        super(message);

        this.code = errorEnum.getCode();

    }

}
