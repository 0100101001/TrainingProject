package pages;

import base.TestBase;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class StepsOnTheMainPage extends TestBase {

  @Step("Перейти на страницу авторизации пользователя")
  public void goToLoginPage() {
//    Atlas atlas = new Atlas(new WebDriverConfiguration(webDriver, "https://mvideo.ru"));
    MainPage mainPage = atlas.create(webDriver, MainPage.class);

    mainPage.linkToLoginPage().click();
//    mainPage.goToLoginPage();

    Assert.assertTrue(webDriver.getCurrentUrl().contains("/login"),
            "Переход на страницу авторизации не осуществлен");
  }

}
