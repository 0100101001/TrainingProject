package loginTests;

import base.TestBase;
import dataProvider.DataProvider;
import org.testng.annotations.Test;
import pages.PageObject;
import testData.users.LoginAndPassword;

import java.io.IOException;

public class TestLogin extends TestBase {

    @Test(description = "Проверка успешной авторизации")
    public void SuccessfulLoginTest() {
        LoginAndPassword loginAndPassword = new LoginAndPassword();

        String login = loginAndPassword.login;
        String password = loginAndPassword.password;

        // Перейти на сайт
        onSite().openSite();

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
        LoginAndPassword loginAndPassword = new LoginAndPassword();

        String login = loginAndPassword.invalidLogin;
        String password = loginAndPassword.invalidPassword;

        // Перейти на сайт
        onSite().openSite();

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
