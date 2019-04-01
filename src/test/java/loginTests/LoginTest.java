package loginTests;

import dataProvider.DataProvider;
import enums.LoginAndPassword;
import loginTests.steps.StepsLoginTest;
import org.testng.annotations.Test;

public class LoginTest extends StepsLoginTest {

  StepsLoginTest stepsLoginTest = new StepsLoginTest();

  @Test(description = "Авторизация", dataProvider = "login", dataProviderClass = DataProvider.class)
  public void LoginTests(String login, String password) {

    /* Перейдем на страницу авторизации */
    stepsLoginTest.goToLoginPage();

    if(login.equals(LoginAndPassword.autotestuserFail.name())) {
      /* Авторизуемся пользователем (некорректные данные)*/
      stepsLoginTest.login(login, password);
    }else {
      /* Авторизуемся пользователем (корректные данные)*/
      stepsLoginTest.loginIncorrectData(login, password);
    }
  }
}
