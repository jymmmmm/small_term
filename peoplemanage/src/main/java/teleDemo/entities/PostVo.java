package teleDemo.entities;

import java.util.List;

public class PostVo<T>{
    private int code;
    private String msg;
    private List<T> data;

    public PostVo(int code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public PostVo() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
