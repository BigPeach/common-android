package com.ymr.common.bean;

/**
 * Created by ymr on 15/5/7.
 */
public class ApiBase<T> implements IApiBase<T> {

    public static final int SUCCESS = 0;
    private int code;
    private String msg;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public T getData() {
        return result;
    }

    @Override
    public int getSuccessCode() {
        return SUCCESS;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApiBase{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
