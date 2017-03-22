package cn.ecomb.conllection;

import org.junit.Test;

import java.util.*;

/**
 * Created by zhouzg on 2017/2/6.
 */
public class ObjectMethodTest {

    @Test
    public void TestObjectMethod(){
        Object obj = new Object();
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        System.out.println(obj.getClass());
        System.out.println(":");
    }

    @Test
    public void TestMap(){
        Collection collection =new ArrayList();


        Map hashMap = new HashMap();
        List arrarylist = new ArrayList();
        List linkedList = new LinkedList();
    }

    @Test
    public void TestString(){
        System.out.println("---7987".matches("-{1,3}?\\d+"));
        System.out.println("++7987".matches("(-{1,2}|\\+{1,2})?\\d+"));
        String str = "System.out.println();";
        System.out.println(Arrays.toString(str.split("/")));
    }



}
