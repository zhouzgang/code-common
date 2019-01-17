package cn.ecomb.netty.noi;

/**
 * @author zhouzg
 * @date 2019/1/17
 */
public class TimeClient {
    public static void main(String[] args) {

        int port = 80;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        for (int i = 0; i < 10000; i++) {
            new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
        }
    }
}
