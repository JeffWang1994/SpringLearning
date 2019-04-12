package top.jeffwang.demo.domain;

import java.io.Serializable;

public class JsonData implements Serializable {

    private static final long serialVersionUID = 1L;

    // 状态码, 0表示成功, -1表示失败
    private int code;

    // 错误描述
    private String msg;

    // 结果
    private Object data;

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
