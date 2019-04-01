package pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface MainPage extends WebPage {

  @FindBy(".//div[@class='header-main-area']//a[@href='/login']")
  AtlasWebElement linkToLoginPage();

  /**
   * Переход с главной странице по ссылке "Войти" на страницу авторизации
   */
  default void goToLoginPage() {
    linkToLoginPage().click();
  }
}
