package com.qinchao.cms.utils;

import java.io.Serializable;


/**
 * @author qinc
 * @description
 * @date 2018/12/11
 */
public class ActionResult implements Serializable {

    private static final long serialVersionUID = -6614400429699484429L;

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ActionResult build(Integer status, String msg, Object data) {
        return new ActionResult(status, msg, data);
    }

    public static ActionResult ok(Object data) {
        return new ActionResult(data);
    }

    public static ActionResult ok() {
        return new ActionResult(null);
    }

    public ActionResult() {

    }

    public static ActionResult build(Integer status, String msg) {
        return new ActionResult(status, msg, null);
    }

    public ActionResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ActionResult(Object data) {
        this.status = 200;
        this.msg = "操作成功！";
        this.data = data;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
