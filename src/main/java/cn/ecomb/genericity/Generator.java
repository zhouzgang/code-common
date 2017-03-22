package cn.ecomb.genericity;

/**
 * 生成器接口
 * Created by zhouzg on 2017/3/7.
 */
public interface Generator<T> {
    T next();
}
