package loginTests;

import base.Configuration;
import base.WebTestRunner;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.PageObject;

public class LoginTest extends WebTestRunner {
    private Configuration configuration = ConfigFactory.create(Configuration.class, System.getProperties());

    @Test(description = "Проверка успешной авторизации")
    public void SuccessfulLoginTest() {

        String login = configuration.userLogin();
        String password = configuration.userPassword();
        System.out.println(login + " / " + password);
        // Перейти на сайт
        goToWebsite();

        // Перейти на страницу авторизации
        onSite().onHeader.goToLoginPage();

        // Проверить, что открыта страница авторизации
        onSite().onLoginPage.checkThatTheLoginPageIsOpen();

        // Проверить, что отображается форма авторизации
        onSite().onLoginPage.verifyThatTheLoginformIsDisplayed();

        // Ввести логин
        onSite().onLoginPage.inputLogin(login);

        // Ввести пароль
        onSite().onLoginPage.inputPassword(password);

        // Нажать кнопку завершения авторизации
        onSite().onLoginPage.pressSubmitButton();

        // Проверить, что авторизация успешна, отображается аватар пользователя
        onSite().onMyAccountPage.loginCheck();
    }

    @Test(description = "Проверка авторизации с некорректными данными")
    public void incorrectDataLoginTest() {

        String login = configuration.userLoginInvalid();
        String password = configuration.userPasswordInvalid();

        // Перейти на сайт
        goToWebsite();

        // Перейти на страницу авторизации
        onSite().onHeader.goToLoginPage();

        // Проверить, что открыта страница авторизации
        onSite().onLoginPage.checkThatTheLoginPageIsOpen();

        // Проверить, что отображается форма авторизации
        onSite().onLoginPage.verifyThatTheLoginformIsDisplayed();

        // Ввести логин
        onSite().onLoginPage.inputLogin(login);

        // Ввести пароль
        onSite().onLoginPage.inputPassword(password);

        // Нажать кнопку завершения авторизации
        onSite().onLoginPage.pressSubmitButton();

        // Проверить, что авторизация не удалась - отображается сообщение об ошибке
        onSite().onLoginPage.checkNotificationError();
    }

    private PageObject onSite() {
        return atlas.create(webDriver, PageObject.class);
    }
}
