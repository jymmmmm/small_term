package teleDemo.entities;

import java.util.List;

public class GetVo<T>{
    private int code;
    private String msg;
    private int count;
    private List<T> data;

    public GetVo(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public GetVo() {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
