package cn.ecomb.common;

/**
 * @author zhouzhigang
 * @date 2017/12/25.
 */
public class User {

    private String name;

    private Integer age;

    private static String id;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        User.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
//                ", age=" + age +
                '}';
    }
}
