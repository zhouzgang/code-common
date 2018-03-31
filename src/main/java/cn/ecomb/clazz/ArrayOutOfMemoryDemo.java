package cn.ecomb.clazz;

/**
 * @author zhouzhigang
 * @date 2018/3/3.
 */
public class ArrayOutOfMemoryDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            byte[] b = new byte[8 * 1024 * 1024];
                            Thread.sleep(100);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
