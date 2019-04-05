package testData.users;

import utility.Utility;

import java.io.IOException;

public class LoginAndPassword {
    Utility utility = new Utility();

    /* Корректные логин и пароль*/
    public String login = utility.getProperties("user.login");
    public String password = utility.getProperties("user.password");

    /* Некорректные логин и пароль для негативного теста */
    public String invalidLogin = utility.getProperties("user.login.invalid");
    public String invalidPassword = utility.getProperties("user.password.invalid");

}
