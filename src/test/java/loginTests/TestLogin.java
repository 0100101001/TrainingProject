package loginTests;

import base.TestBase;
import dataProvider.DataProvider;
import org.testng.annotations.Test;
import pages.PageObject;
import pages.loginPage.LoginPage;
import pages.loginPage.StepsOnTheLoginPage;
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
        webDriver.get(url);

        // Перейти на страницу авторизации
        onSite().onMainPage().linkToLoginPage().click();

        // Проверить, что открыта страница авторизации
        onSite().onLoginPage().checkThatTheLoginPageIsOpen();

        // Проверить, что отображается форма авторизации
        onSite().onLoginPage().formLogin().isDisplayed();

        // Ввести логин
        onSite().onLoginPage().inputLogin().sendKeys(login);

        // Ввести пароль
        onSite().onLoginPage().inputPassword().sendKeys(password);

        // Нажать кнопку завершения авторизации
        onSite().onLoginPage().buttonSubmit().click();

        // Проверить, что авторизация успешна, отображается аватар пользователя
        onSite().onMyAccountPage().userAvatar().isDisplayed();
    }

    private PageObject onSite() {

        return atlas.create(webDriver, PageObject.class);

    }
}
