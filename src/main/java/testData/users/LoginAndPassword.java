package testData.users;

import utility.Utility;

import java.io.IOException;

public class LoginAndPassword {
  Utility utility = new Utility();

  /* Корректные логин и пароль*/
  private String login = utility.getProperties("UserLogin");
  private String password = utility.getProperties("UserPassword");

  /* Некорректные логин и пароль для негативного теста */
  private String invalidLogin = utility.getProperties("UserLoginInvalid");
  private String invalidPassword = utility.getProperties("UserPasswordInvalid");

  public LoginAndPassword() throws IOException {
  }


//  private Properties getProperties() {
//    Path propertyFile = Paths.get("src/test/resources/application.properties");
//    try {
//      Files.lines(propertyFile, Charset.forName("UTF-8"));
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    Properties properties = new Properties();
//    Reader PropReader;
//
//      try {
//        PropReader = Files.newBufferedReader(propertyFile);
//        properties.load(PropReader);
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    return properties;
//  }

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
