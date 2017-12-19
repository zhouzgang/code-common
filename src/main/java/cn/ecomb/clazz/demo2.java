package cn.ecomb.clazz;

import java.io.IOException;

/**
 * @author zhouzhigang
 * @date 2017/12/5.
 */
public class demo2 {

    public static void main(String[] args) {
        try {
            System.out.println(inc());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int inc() throws Exception {
        int x;
        try {
            x = 1;
            if (1 == 1) {
                throw new Exception();
            }
            return x;
        } catch (IOException e) {
            x = 2;
            return x + 4;
        }finally {
            x = 3;
//            return x;
        }
    }
}
