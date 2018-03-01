package com.example.demo.utils;

/**
 * Created by Summer on 2017/12/11.
 */

import java.io.Serializable;


@SuppressWarnings("rawtypes")
public class ResponseDO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int SUCCESS_CODE = 200;

    public static final int FAIL_CODE = 201;

    public static final String SUCCESS_MSG = "操作成功";

    public static final String SUCCESS_DATA = "Success";

    public static final String FAIL_MSG = "操作失败";

    public static final String FAIL_DATA = "Fail";

    /**
     *
     */
    private Integer code;

    private String msg;

    private T data;

    public ResponseDO() {
    }

    public ResponseDO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseDO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseDO(T data) {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
        this.data = data;
    }


    public static ResponseDO flag(boolean flags) {
        if (flags) {
            return new ResponseDO(SUCCESS_CODE, SUCCESS_MSG, SUCCESS_DATA);
        } else {
            return new ResponseDO(FAIL_CODE, FAIL_MSG, FAIL_DATA);
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
