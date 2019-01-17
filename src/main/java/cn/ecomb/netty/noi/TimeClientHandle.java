package cn.ecomb.netty.noi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhouzg
 * @date 2019/1/17
 */
public class TimeClientHandle implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;

    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host == null
                ? "127.0.0.1"
                : host;
        this.port = port;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            if (socketChannel.connect(new InetSocketAddress(host, port))) {
                socketChannel.register(selector, SelectionKey.OP_READ);
                System.out.println("--->" + Thread.currentThread().getName());
                byte[] req = "QUERY TIME ORDERs".getBytes();
                ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
                writeBuffer.put(req);
                writeBuffer.flip();
                socketChannel.write(writeBuffer);
                if (!writeBuffer.hasRemaining()) {
                    System.out.println("Send order to server succeed");
                }
            } else {
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        if (key.isValid()) {
                            SocketChannel sc = (SocketChannel) key.channel();
                            if (key.isConnectable()) {
                                if (sc.finishConnect()) {
                                    sc.register(selector, SelectionKey.OP_READ);
                                    //发送请求消息，读应答
                                    byte[] req = "QUERY TIME ORDER".getBytes();
                                    ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
                                    writeBuffer.put(req);
                                    writeBuffer.flip();
                                    sc.write(writeBuffer);
                                    if (!writeBuffer.hasRemaining()) {
                                        System.out.println("Send order 2 server succeed.");
                                    }
                                } else {
                                    System.exit(1);
                                }
                            }
                            if (key.isReadable()) {
                                //第九步：读取信息到缓冲区
                                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                                int readBytes = sc.read(readBuffer);
                                if (readBytes > 0) {
                                    readBuffer.flip();
                                    byte[] bytes = new byte[readBuffer.remaining()];
                                    readBuffer.get(bytes);
                                    String body = new String(bytes, "UTF-8");
                                    System.out.println("Now is : " + body);
                                    this.stop = true;
                                } else if (readBytes < 0) {
                                    // 对端链路关闭
                                    key.cancel();
                                    sc.close();
                                } else {
                                    ; // 读到0字节，忽略
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
                System.exit(1);
            }
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
