package com.shanyangcode2.infinitechat.constants;

public enum ConfigEnum {
    SMS_ACCESS_KEY_ID(env("SMS_ACCESS_KEY_ID")),
    SMS_ACCESS_KEY_SECRET(env("SMS_ACCESS_KEY_SECRET")),
    SMS_SIG_NAME(env("SMS_SIG_NAME")),
    SMS_TEMPLATE_CODE(env("SMS_TEMPLATE_CODE")),
    TOKEN_SECRET_KEY(env("TOKEN_SECRET_KEY", "change-me")),
    PASSWORD_SALT(env("PASSWORD_SALT", "change-me")),
    WX_STATE(env("WX_STATE", "change-me")),
    WORKED_ID("1"),
    DATACENTER_ID("1"),
    IMAGE_URI(env("MINIO_IMAGE_URI", "http://127.0.0.1:9000/infinitec-chat/")),
    IMAGE_PATH("/home/img/avatar"),
    NOTICE_URL("/api/v1/message/push/moment"),
    MEDIA_TYPE("application/json; charset=utf-8"),
    MINIO_SERVER_URL(env("MINIO_URL", "http://127.0.0.1:9000")),
    MINIO_ACCESS_KEY(env("MINIO_ACCESS_KEY")),
    MINIO_SECRET_KEY(env("MINIO_SECRET_KEY")),
    REQUEST_SUCCESSFUL("请求成功"),
    MINIO_BUCKET_NAME("infinitec-chat");

    private final String value;

    private static String env(String name) {
        return env(name, "");
    }

    private static String env(String name, String defaultValue) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? defaultValue : value;
    }

    ConfigEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
