package loginTests;

import dataProvider.DataProvider;
import enums.LoginAndPassword;
import loginTests.steps.StepsLoginTest;
import org.testng.annotations.Test;

public class LoginTest extends StepsLoginTest {

  StepsLoginTest stepsLoginTest = new StepsLoginTest();

  //TODO дописать тест/написать второй тест на негативную проверку(параметризовать)

  @Test(description = "Авторизация", dataProvider = "login", dataProviderClass = DataProvider.class)
  public void LoginTests(String login, String password) {
//    String login = LoginAndPassword.login.value;
//    String password = LoginAndPassword.password.value;

    /* Перейдем на страницу авторизации */
    stepsLoginTest.goToLoginPage();

    if(login.equals(LoginAndPassword.autotestuserFail.name())) {
      /* Авторизуемся пользователем (некорректные данные)*/
      stepsLoginTest.login(login, password, "Некорректные данные");
    }else {
      /* Авторизуемся пользователем (корректные данные)*/
      stepsLoginTest.login(login, password);
    }
  }
}
