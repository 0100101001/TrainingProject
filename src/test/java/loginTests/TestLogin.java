package loginTests;

import base.TestBase;
import dataProvider.DataProvider;
import enums.LoginAndPassword;
import org.testng.annotations.Test;
import pages.loginPage.StepsOnTheLoginPage;
import pages.mainPage.StepsOnTheMainPage;

public class TestLogin extends TestBase {
  protected StepsOnTheMainPage stepsOnTheMainPage = new StepsOnTheMainPage();
  protected StepsOnTheLoginPage stepsOnTheLoginPage = new StepsOnTheLoginPage();

  @Test(description = "Авторизация", dataProvider = "login", dataProviderClass = DataProvider.class)
  public void loginTests(String login, String password) {

    /* Перейдем на страницу авторизации */
    stepsOnTheMainPage.goToLoginPage();

    /* Авторизуемся пользователем*/
    if(login.equals(LoginAndPassword.autotestuserFail.name())) {
      /* Авторизуемся пользователем (некорректные данные)*/
      stepsOnTheLoginPage.loginIncorrectData(login, password);
    }else {
      /* Авторизуемся пользователем (корректные данные)*/
      stepsOnTheLoginPage.login(login, password);
    }

  }
}
