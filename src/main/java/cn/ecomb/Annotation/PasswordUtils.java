package cn.ecomb.Annotation;

/**
 * Created by zhouzg on 2017/2/8.
 */
public class PasswordUtils {

    @UseCase(id = 47 , description = "validate Password")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d*\\w*"));
    }

    @UseCase(id = 48, description = "dd")
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

}
