package pages.mainPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import pages.popupMsgAndBanner.PopupMsgAndBanner;
import ru.yandex.qatools.allure.annotations.Description;

public interface MainPage extends WebPage, PopupMsgAndBanner {

  /**
   *Ссылка на страницу авторизации "Войти"
   */
  @Description("Ссылка на страницу авторизации 'Войти'")
  @FindBy(".//div[@class='header-main-area']//a[@href='/login']")
  AtlasWebElement linkToLoginPage();

  /**
   * Переход с главной странице по ссылке "Войти" на страницу авторизации
   */
  default void goToLoginPage() {
    closeOverlapLayer(); //закроем баннер, если появился

    linkToLoginPage().click(); //нажмем на ссылку "Войти"
  }
}
