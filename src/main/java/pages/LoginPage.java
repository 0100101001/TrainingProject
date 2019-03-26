package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

  /**
   * Поле ввода Телефона/Email
   */
  @FindBy(id = "frm-email")
  WebElement inputLogin;

  /**
   * Поле ввода пароля
   */
  @FindBy(id = "frm-password")
  WebElement inputPassword;

  /**
   * Кнопка "Продолжить" в форме авторизации
   */
  @FindBy(name = "loginEmailPhone")
  WebElement buttonSubmit;

  /**
   * Сообщение о том, что логин или пароль неверны
   */
  @FindBy(xpath = "//form[@id='login-form']//div[contains(@class, 'login-notification-error')]")
  WebElement messageNotificationError;

  public LoginPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    waitForPageLoad(webDriver);
    PageFactory.initElements(webDriver, this);
  }

  /**
   * Авторизация (заполнение логина, пароля и нажатие на кнопку завершения авторизации)
   * @param login - логин пользователя
   * @param password - пароль
   * @return - вернет true, усли авторизация прошла(отображается аватар пользователя, иначе вернет false
   */
  public boolean login(String login, String password) {
    MyAccountPage myAccountPage = new MyAccountPage(webDriver);
    waitVisibilityOrClickableElement(inputLogin, 10);

    inputLogin.click();
    inputLogin.clear();
    inputLogin.sendKeys(login);

    inputPassword.click();
    inputPassword.clear();
    inputPassword.sendKeys(password);

    buttonSubmit.click();
    waitForPageLoad(webDriver);

    return waitVisibilityOrClickableElement(myAccountPage.userAvatar, 5);
  }
}
