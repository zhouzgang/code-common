package cn.ecomb.Annotation;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 注释处理器
 * Created by zhouzg on 2017/2/8.
 */
public class UseCaseTracker {

    public static void trackerUserCase(List<Integer> useCases, Class<?> cl){
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id());
                useCases.remove(new Integer(uc.id()));
            }
        }
    }
}
