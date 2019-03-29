package loginTests.steps;

import base.TestBase;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.mainPage.MainPage;

public class ActionsOnTheMainPage extends TestBase {

  @Step("Перейти на страницу авторизации пользователя")
  public void goToLoginPage() {
    MainPage mainPage = new MainPage(webDriver);
    mainPage.goToLoginPage();
    Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"),
            "Переход на страницу авторизации не осуществлен");
  }
}
