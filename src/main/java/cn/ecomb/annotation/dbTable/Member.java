package cn.ecomb.annotation.dbTable;

/**
 * Created by zhouzhigang on 2017/11/1.
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    private String firstName;

    @SQLString(50)
    private String lastName;

    @SQLInteger(name = "age")
    private Integer age;

    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    private String handle;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    @Override
    public String toString() {
        return "Member{" +
                "handle='" + handle + '\'' +
                '}';
    }
}
