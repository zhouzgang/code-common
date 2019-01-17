package cn.ecomb.netty.noi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO 服务测试
 * @author zhouzg
 * @date 2019/1/15
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        new Thread(new ReactorTask()).start();
    }


    public static class ReactorTask implements Runnable{
        private Selector selector;

        public ReactorTask() {
            try {
                System.out.println("------new------");
                ServerSocketChannel acceptorSvr = ServerSocketChannel.open();
                acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 80));
                acceptorSvr.configureBlocking(false);
                selector = Selector.open();
                acceptorSvr.register(selector, SelectionKey.OP_ACCEPT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("------run------");
                    selector.select(1000);
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> it =  selectionKeys.iterator();
                    SelectionKey key = null;
                    while (it.hasNext()) {
                        key = it.next();
                        it.remove();
                        try {
                            if (key.isValid()) {
                                if (key.isAcceptable()) {
                                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                                    SocketChannel sc = ssc.accept();
                                    sc.configureBlocking(false);
                                    sc.socket().setReuseAddress(true);
                                    sc.register(selector, SelectionKey.OP_READ);
                                }
                                if (key.isReadable()) {
                                    SocketChannel scc = (SocketChannel) key.channel();
                                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                                    int readBytes = scc.read(readBuffer);
                                    if (readBytes > 0) {
                                        readBuffer.flip();
                                        byte[] bytes = new byte[readBuffer.remaining()];
                                        readBuffer.get(bytes);
                                        String body = new String(bytes, "UTF-8");
                                        System.out.println("the times server receive order: " + body);
                                        String currentTime = "query time order".equalsIgnoreCase(body)
                                                ? new Date(System.currentTimeMillis()).toString()
                                                : "bad order";
                                        byte[] bytes1 = currentTime.getBytes();
                                        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes1.length);
                                        writeBuffer.put(bytes1);
                                        writeBuffer.flip();
                                        scc.write(writeBuffer);
                                    } else if (readBytes < 0) {
                                        key.channel();
                                        scc.close();
                                    } else {
                                    }
                                }
                            }
                        } catch (Exception e) {
                            if (key != null) {
                                key.cancel();
                                if (key.channel() != null) {
                                    key.channel().close();
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}

