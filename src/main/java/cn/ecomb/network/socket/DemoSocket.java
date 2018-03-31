package cn.ecomb.network.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author zhouzhigang
 * @date 2018/3/28.
 */
public class DemoSocket {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(new ObjectOutputStream(outputStream), true);
        pw.println("hello tomcat");

        StringBuffer requestResult = new StringBuffer();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            String s = new String(bytes);
            System.out.println(s);
            requestResult.append(s);
        }
        System.out.println(requestResult);
        socket.close();
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
