package cn.ecomb.concurrent;

import cn.ecomb.common.User;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference
 *
 * @author zhouzhigang
 * @date 2017/12/26.
 */
public class Atomic_demo2 {

    public static AtomicReference<User> userAtomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User u1 = new User();
        u1.setAge(1).setName("xiaoming");
        userAtomicReference.set(u1);
        User u2 = new User();
        u2.setAge(2).setName("xiaohua");
        userAtomicReference.compareAndSet(u1, u2);
        System.out.println(userAtomicReference.get().toString());
    }

}
