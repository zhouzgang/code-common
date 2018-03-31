package cn.ecomb.network.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhouzhigang
 * @date 2018/3/29.
 */
public class DemoServer {

    private final static String REQUEST_SUCCESS = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html\r\n" +
            "\r\n" +
            "请求成功" ;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("localhost"));
            boolean stop = false;
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            StringBuffer stringResult = new StringBuffer();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes) != -1) {
                String s = new String(bytes);
                System.out.println(s);
                stringResult.append(s);
            }

            System.out.println(("request info:" + stringResult).getBytes("utf-8"));
            outputStream.write(REQUEST_SUCCESS.getBytes());
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
