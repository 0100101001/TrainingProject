package testData.users;

import utility.Utility;

import java.io.IOException;

public class LoginAndPassword {
  Utility utility = new Utility();

  /* Корректные логин и пароль*/
  private String login = utility.getProperties("user.login");
  private String password = utility.getProperties("user.password");

  /* Некорректные логин и пароль для негативного теста */
  private String invalidLogin = utility.getProperties("user.login.invalid");
  private String invalidPassword = utility.getProperties("user.password.invalid");

  public LoginAndPassword() throws IOException {
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public String getInvalidLogin() {
    return invalidLogin;
  }

  public String getInvalidPassword() {
    return invalidPassword;
  }
}
