package cn.ecomb.pattern.creative;

import org.junit.Test;

/**
 * Created by arron on 2016/12/19.
 */
public class TestCreativePattern {

    @Test
    public void testSingleton(){
        ExerciseSingleton exerciseSingleton = new ExerciseSingleton();
        exerciseSingleton.execute();
    }

    @Test
    public void testConstructor() {
        ExeciseConstructor execiseConstructor = new ExeciseConstructor();
        execiseConstructor.execute();
    }
}
