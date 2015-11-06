package com.ymr.common.bean;

/**
 * Created by ymr on 15/11/6.
 */
public interface IApiBase<D> {
    int getCode();
    String getMsg();
    D getData();

    int getSuccessCode();
}
