package cn.ecomb.clazz;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器
 *
 * @author zhouzhigang
 * @date 2017/12/7.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("cn.ecomb.clazz.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof cn.ecomb.clazz.ClassLoaderTest);
        Object obj1 = new ClassLoaderTest();
        System.out.println(obj1 instanceof cn.ecomb.clazz.ClassLoaderTest);

    }
}
