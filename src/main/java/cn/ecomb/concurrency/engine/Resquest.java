package cn.ecomb.concurrency.engine;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class Resquest {
    private String param;

    private Response response;

    public Resquest() {
    }

    public Resquest(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public Resquest setParam(String param) {
        this.param = param;
        return this;
    }

    public Response getResponse() {
        return response;
    }

    public Resquest setResponse(Response response) {
        this.response = response;
        return this;
    }
}
