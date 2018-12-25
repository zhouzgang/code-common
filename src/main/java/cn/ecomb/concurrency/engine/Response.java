package cn.ecomb.concurrency.engine;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
public class Response {

    private String Uid;
    private String body;

    public Response() {
    }

    public Response(String uid) {
        Uid = uid;
    }

    public String getUid() {
        return Uid;
    }

    public Response setUid(String uid) {
        Uid = uid;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Response setBody(String body) {
        this.body = body;
        return this;
    }
}
