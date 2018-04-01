package cn.ecomb.io.nio;

/**
 * @author zhouzhigang
 * @date 2018/4/1.
 */
public class Server {
    private static int DEFAULT_PORT = 8080;
    private static ServerHandle serverHandle;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {

    }

    public static void main(String[] args) {
        start();
    }

}
