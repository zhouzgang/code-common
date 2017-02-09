package cn.ecomb.Concurrency;

import org.junit.Test;

/**
 * Created by arron on 2017/2/8.
 */
public class TestListOff {

    @Test
    public void testListOff(){
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
