package pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.WebElement;

public interface LoginPage extends WebPage, MyAccountPage {

  /**
   * Поле ввода Телефона/Email
   */
  @FindBy("frm-email")
  AtlasWebElement inputLogin();

  /**
   * Поле ввода пароля
   */
  @FindBy("frm-password")
  AtlasWebElement inputPassword();

  /**
   * Кнопка "Продолжить" в форме авторизации
   */
  @FindBy("loginEmailPhone")
  AtlasWebElement buttonSubmit();

  /**
   * Сообщение о том, что логин или пароль неверны
   */
  @FindBy("//form[@id='login-form']//div[contains(@class, 'login-notification-error')]")
  AtlasWebElement messageNotificationError();


  /**
   * Авторизация (заполнение логина, пароля и нажатие на кнопку завершения авторизации)
   * @param login - логин пользователя
   * @param password - пароль
   * @return - вернет true, усли авторизация прошла(отображается аватар пользователя, иначе вернет false
   */
  default void login(String login, String password) {

    inputLogin().click();
    inputLogin().clear();
    inputLogin().sendKeys(login);

    inputPassword().click();
    inputPassword().clear();
    inputPassword().sendKeys(password);

    buttonSubmit().click();
//    return userAvatar().waitUntil();
//    userAvatar().should("User is not found", WebElement::isDisplayed);
//    return waits.waitVisibilityOrClickableElement(myAccountPage.userAvatar, 5, webDriver);
  }
}


