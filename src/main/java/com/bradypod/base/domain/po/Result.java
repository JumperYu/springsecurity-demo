package com.bradypod.base.domain.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 * @author https://github.com/JumperYu
 * @version 2019/09/29
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    /**
     * 返回代码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 返回对象
     */
    private T data;

    /**
     * 是否成功，readonly
     */
    private boolean success;

    public static <T> Result<T> success(T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setSuccess(true).setData(data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<T>().setCode(code).setSuccess(false).setMessage(message);
    }

    public static <T> Result<T> fail(String message) {
        return fail(ResultCode.FAILURE, message);
    }
}
