package cn.ecomb.pattern.structure;

import org.junit.Test;

/**
 * Created by arron on 2016/12/21.
 */
public class TestStructurePattern {

    @Test
    public void testStaticProxy(){
        new ExeciseStaticProxy().execute();
    }

    @Test
    public void testDynamicProxy() {
        new ExeciseDynamicProxy().execute();
    }
}
