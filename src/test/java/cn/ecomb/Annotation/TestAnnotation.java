package cn.ecomb.Annotation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhouzg on 2017/2/8.
 */
public class TestAnnotation {

    @Test
    public void TestTracker(){
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 90);
        UseCaseTracker.trackerUserCase(useCases, PasswordUtils.class);
    }
}
