package com.liebe;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/31.
 */
public class Result<T> implements Serializable {

    private String code;

    private String message;

    private T data;

    public Result(){

    }

    public Result (T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        return new Result(data);
    }

    public static  <T> Result<T> error(String code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
