package cn.ecomb.concurrent;

import cn.ecomb.common.User;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Unsafe 类
 *
 * @author zhouzhigang
 * @date 2017/12/25.
 */
public class Unsafe_Demo1 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);

        User user = (User) unsafe.allocateInstance(User.class);

        Class userClass = user.getClass();
        Field name = userClass.getDeclaredField("name");
        Field age = userClass.getDeclaredField("age");
        Field id = userClass.getDeclaredField("id");

        unsafe.putInt(user, unsafe.objectFieldOffset(age), 18);
        unsafe.putObject(user, unsafe.objectFieldOffset(name), "hahaha");

        Object staticBase = unsafe.staticFieldBase(id);
        System.out.println("staticBase: " + staticBase);

        long staticId = unsafe.staticFieldOffset(userClass.getDeclaredField("id"));
        System.out.println("staticId field off set: "+ staticId);
        System.out.println("设置前的ID： " + unsafe.getObject(staticBase, staticId));

        unsafe.putObject(staticBase, staticId, "SSSSSSS");
        System.out.println("设置前的ID： " + unsafe.getObject(staticBase, staticId));

        System.out.println("user: " + user.toString());
    }
}
