package ratanak.pek.restful.controller;

/**
 * Created by r.pek on 12/21/2017.
 */
public class HelloWorldBean {
    private String msg;
    public HelloWorldBean(String s) {
        this.msg=s;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
