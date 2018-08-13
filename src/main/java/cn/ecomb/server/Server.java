package cn.ecomb.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author zhouzhigang
 * @date 2018/6/20.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = null;
        try {
            listener = new ServerSocket(8080);
            while (true) {
                Socket socket = listener.accept();
                try {
                    handleRequest(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            listener.close();
        }
    }

    final static String response =
            "HTTP/1.0 200 OKrn" +
                    "Content-type: text/plainrn" +
                    "rn" +
                    "Hello Worldrn";

    static Logger logger = LoggerFactory.getLogger(Server.class);

    public static void handleRequest(Socket socket) throws IOException {
        // Read the input stream, and return "200 OK"
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            logger.info(in.readLine());

            OutputStream out = socket.getOutputStream();
            out.write(response.getBytes(StandardCharsets.UTF_8));
        } finally {
            socket.close();
        }
    }
}
