package loginTests.steps;

import base.TestBase;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;

public class StepsLoginTest extends TestBase {

  @Step("Перейти на страницу авторизации пользователя")
  public void goToLoginPage() {
    MainPage mainPage = new MainPage(webDriver);
    mainPage.goToLoginPage();
    Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"),
            "Переход на страницу авторизации не осуществлен");
  }

  @Step("Авторизация")
  public void login(String login, String password) {
    LoginPage loginPage = new LoginPage(webDriver);

    Assert.assertTrue(loginPage.login(login, password),
            "Авторизоваться не удалось");
  }

  @Step("Авторизация ({2})")
  public void login(String login, String password, String typeLogin) {
    LoginPage loginPage = new LoginPage(webDriver);

    Assert.assertFalse(loginPage.login(login, password),
            "Пользователь "+login+" авторизовался");

    Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"),
            "Переход на страницу авторизации не осуществлен");

    Assert.assertTrue(loginPage.checkNotificationError(), "Сообщение об ошибке не отображается!");
  }
}
