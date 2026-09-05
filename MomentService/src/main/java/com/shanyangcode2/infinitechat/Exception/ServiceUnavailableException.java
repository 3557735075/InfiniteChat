package com.shanyangcode2.infinitechat.Exception;

public class ServiceUnavailableException extends RuntimeException {
    public ServiceUnavailableException(String message) {
        super(message);
    }
    public ServiceUnavailableException() {
        super("Netty服务不可用");
    }
}
