package pages.loginPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import org.testng.Assert;

public interface LoginPage extends WebPage {

    @Name("Форма авторизации")
    @FindBy("//form[@id='login-form']")
    AtlasWebElement formLogin();

    @Name("Логин")
    @FindBy("//input[@id='frm-email']")
    AtlasWebElement inputLogin();

    @Name("Пароль")
    @FindBy("//input[@id='frm-password']")
    AtlasWebElement inputPassword();

    @Name("Кнопка 'Продолжить'")
    @FindBy("//input[@name='loginEmailPhone']")
    AtlasWebElement buttonSubmit();

    @Name("Сообщение об ошибке авторизации")
    @FindBy("//form[@id='login-form']//div[contains(@class, 'login-notification-error')]")
    AtlasWebElement messageNotificationError();

    default void checkNotificationError() {
        Assert.assertTrue(messageNotificationError().isDisplayed(), "Сообщение об ошибке не отображается");
    }

    default void checkThatTheLoginPageIsOpen() {
        Assert.assertTrue(getWrappedDriver().getCurrentUrl().contains("/login"),
                "Переход на страницу авторизации не осуществлен");
    }

    default void verifyThatTheLoginformIsDisplayed() {
        Assert.assertTrue(formLogin().isDisplayed(), "Форма авторизации не отображается");
    }
}


