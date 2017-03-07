package cn.ecomb.Genericity;

/**
 * Created by zhouzg on 2017/3/7.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
