package cn.ecomb.annotation.dbTable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zhouzhigang on 2017/11/1.
 */
public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> cl = TableCreator.class.getClassLoader()
                .loadClass("cn.ecomb.annotation.dbTable.Member");
        Annotation[] annotation = cl.getAnnotations();
        System.out.println(cl.getName().toUpperCase());

        for (Field field: cl.getDeclaredFields()) {
            System.out.println(field.getName());
            System.out.println(field.getDeclaredAnnotations()[0].toString());
        }
    }
}
