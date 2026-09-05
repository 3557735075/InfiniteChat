package com.shanyangcode.infinitechat.realtimecommunicationservice.constants;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ConfigEnum {

    SMS_ACCESS_KEY_ID("smsAccessKeyId", env("SMS_ACCESS_KEY_ID")),
    SMS_ACCESS_KEY_SECRET("smsAccessKeySecret", env("SMS_ACCESS_KEY_SECRET")),
    SMS_SIG_NAME("smsSigName", env("SMS_SIG_NAME")),
    SMS_TEMPLATE_CODE("smsTemplateCode", env("SMS_TEMPLATE_CODE")),
    TOKEN_SECRET_KEY("tokenSecretKey", env("TOKEN_SECRET_KEY", "change-me")),
    PASSWORD_SALT("passwordSalt", env("PASSWORD_SALT", "change-me")),
    WX_STATE("wxState", env("WX_STATE", "change-me")),
    WORKED_ID("workedId","1"),
    DATACENTER_ID("DATACENTER_ID","1"),
    IMAGE_URI("imageUri", env("MINIO_IMAGE_URI", "http://127.0.0.1:9000/infinitec-chat/")),
    IMAGE_PATH("imagePath", "/home/img/avatar/"),
    NETTY_SERVER_HEAD("nettyServerHead","Nacos:"),
    REDIS_CONVERT_SEND("redisConvertSend","userLogout");

    private final String text;

    private final String value;

    private static String env(String name) {
        return env(name, "");
    }

    private static String env(String name, String defaultValue) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? defaultValue : value;
    }

    ConfigEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }


    public static List<String> getValues() {
          return Arrays.stream(ConfigEnum.values()).map(ConfigEnum::getValue).collect(Collectors.toList());
    }


    public static ConfigEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (ConfigEnum anEnum : ConfigEnum.values()) {
            if (anEnum.getValue().equals(value)) {
                return anEnum;
            }

        }
        return null;
    }
    public String getText() {
        return text;
    }


    public String getValue() {
        return value;
    }


}
