package com.liebe;

/**
 * Created by Administrator on 2017/7/31.
 */
public class MyException extends RuntimeException {

    private String code;

    private String message;


    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
        this.message = message;
    }

    public MyException(Throwable e){
        super(e);
    }

    public MyException(String code,String message,Throwable e){
        super(message,e);
        this.code = code;
    }

    public MyException(String code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
