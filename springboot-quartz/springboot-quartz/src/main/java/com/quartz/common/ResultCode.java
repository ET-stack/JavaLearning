package com.quartz.common;

/**
 * @className: ResultCode
 * @description: TODO 类描述
 * @date: 2023/4/19
 **/
public enum ResultCode {
    SUCCESS(200, "请求成功"),
    BAD_REQUEST(400, "请求参数有误"),
    UNAUTHORIZED(401, "未认证"),
    FORBIDDEN(403, "请求被拒绝"),
    NOT_FOUND(404, "请求的资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不支持"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}