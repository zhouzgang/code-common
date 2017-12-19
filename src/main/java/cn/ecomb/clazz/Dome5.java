package cn.ecomb.clazz;

import javax.sound.midi.Soundbank;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * java 的动态类型 思考
 *
 * @author zhouzhigang
 * @date 2017/12/12.
 */
public class Dome5 {
    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0
                ? System.out
                : new ClassA();
        System.out.println(obj.getClass());
        getPrintlnMH(obj).invokeExact("fasfdfas");
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
    }
}
