package com.shanyangcode.infinitechat.authenticationservice.constants.config;

import lombok.Getter;

@Getter
public enum ConfigEnum {
    SMS_ACCESS_KEY_ID("smsAccessKeyId", env("SMS_ACCESS_KEY_ID")),
    SMS_ACCESS_KEY_SECRET("smsAccessKeySecret", env("SMS_ACCESS_KEY_SECRET")),
    SMS_SIG_NAME("smsSigName", env("SMS_SIG_NAME")),
    SMS_TEMPLATE_CODE("smsTemplateCode", env("SMS_TEMPLATE_CODE")),
    TOKEN_SECRET_KEY("tokenSecretKey", env("TOKEN_SECRET_KEY", "change-me"));


    private final String value;
    private final String text;

    private static String env(String name) {
        return env(name, "");
    }

    private static String env(String name, String defaultValue) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? defaultValue : value;
    }

    ConfigEnum(String text, String value){
        this.text = text;
        this.value = value;
    }
}
