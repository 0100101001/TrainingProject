package loginTests;

import base.TestBase;
import dataProvider.DataProvider;
import org.testng.annotations.Test;
import pages.PageObject;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.mainPage.StepsOnTheMainPage;
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
        onSite().onMainPage().goToLoginPage();

        // Проверить, что открыта страница авторизации
        onSite().onLoginPage().checkThatTheLoginPageIsOpen();

        // Проверить, что отображается форма авторизации
        onSite().onLoginPage().verifyThatTheLoginformIsDisplayed();

        // Ввести логин
        onSite().onLoginPage().inputLogin(login);

        // Ввести пароль
        onSite().onLoginPage().inputPassword(password);

        // Нажать кнопку завершения авторизации
        onSite().onLoginPage().pressSubmitButton();

        // Проверить, что авторизация успешна, отображается аватар пользователя
        onSite().onMyAccountPage().loginCheck();
    }

    private PageObject onSite() {
        return atlas.create(webDriver, PageObject.class);
    }
}
