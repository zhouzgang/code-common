package cn.ecomb.test;

/**
 * @author zhouzhigang
 * @date 2018/6/19.
 */
public class MaxThreadNum {

    private static Object o = new Object();
    private static int count;
    public static void main(String[] args) {

        for (;;) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(count++);
                    for(;;){
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e){
                            System.err.println(e);
                        }
                    }
                }
            }).start();
        }
    }
}
