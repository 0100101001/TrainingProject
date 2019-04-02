package testData.users;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LoginAndPassword {

  /* Корректные логин и пароль*/
  private String login = getProperties().getProperty("UserLogin");
  private String password = getProperties().getProperty("UserPassword");

  /* Некорректные логин и пароль для негативного теста */
  private String invalidLogin = getProperties().getProperty("UserLoginInvalid");
  private String invalidPassword = getProperties().getProperty("UserPasswordInvalid");


  private Properties getProperties() {
    Properties properties = new Properties();
    Path propertyFile = Paths.get("src/test/resources/application.properties");
    Reader PropReader;

      try {
        PropReader = Files.newBufferedReader(propertyFile);
        properties.load(PropReader);
      } catch (IOException e) {
        e.printStackTrace();
      }
    return properties;
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
