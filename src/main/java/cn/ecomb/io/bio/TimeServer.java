package cn.ecomb.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 《netty 权威指南》
 *
 * @author zhouzhigang
 * @date 2017/12/28.
 */
public class TimeServer {

    public static void main(String[] args) {
        int prot = 8080;
        if (args != null && args.length > 0) {
            prot = Integer.valueOf(args[0]);
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(prot);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
