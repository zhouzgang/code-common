package cn.ecomb.io.bio;

import java.net.Socket;

/**
 * @author zhouzhigang
 * @date 2017/12/28.
 */
public class TimeServerHandler implements Runnable{

    Socket socket = null;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    private TimeServerHandler() {
    }


    @Override
    public void run() {

    }
}
