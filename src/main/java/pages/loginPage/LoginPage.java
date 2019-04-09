package pages.loginPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.testng.Assert;
import pages.myAccountPage.MyAccountPage;
import pages.popupMsgAndBanner.PopupMsgAndBanner;
import ru.yandex.qatools.allure.annotations.Description;

public interface LoginPage extends WebPage, MyAccountPage, PopupMsgAndBanner {

    @Description("Форма авторизации")
    @FindBy("//form[@id='login-form']")
    AtlasWebElement formLogin();

    /**
     * Поле ввода Телефона/Email
     */
    @Description("Логин")
    @FindBy("//input[@id='frm-email']")
    AtlasWebElement inputLogin();

    /**
     * Поле ввода пароля
     */
    @Description("Пароль")
    @FindBy("//input[@id='frm-password']")
    AtlasWebElement inputPassword();

    /**
     * Кнопка "Продолжить" в форме авторизации
     */
    @Description("Кнопка 'Продолжить'")
    @FindBy("//input[@name='loginEmailPhone']")
    AtlasWebElement buttonSubmit();

    /**
     * Сообщение о том, что логин или пароль неверны
     */
    @Description("Сообщение об ошибке авторизации")
    @FindBy("//form[@id='login-form']//div[contains(@class, 'login-notification-error')]")
    AtlasWebElement messageNotificationError();

    /**
     * Ввод пароля
     *
     * @param password - пароль
     */
    default void inputPassword(String password) {
        inputPassword().clear();
        inputPassword().sendKeys(password); //ввод пароля
    }

    /**
     * Нажать на кнопку завершения авторизации
     */
    default void pressSubmitButton() {
        buttonSubmit().click();
    }

    /**
     * Ввод логина
     *
     * @param login - логин пользователя
     */
    default void inputLogin(String login) {
        inputLogin().clear();
        inputLogin().sendKeys(login); //ввод логина
    }

    /**
     * Проверка нотификации при ошибке авторизации
     */
    default void checkNotificationError() {
        Assert.assertTrue(messageNotificationError().isDisplayed(), "Сообщение об ошибке не отображается");
    }

    /**
     * Проверить, что открыта страница авторизации
     */
    default void checkThatTheLoginPageIsOpen() {
        Assert.assertTrue(getWrappedDriver().getCurrentUrl().contains("/login"),
                "Переход на страницу авторизации не осуществлен");
    }

    /**
     * Проверить, что отображается форма авторизации
     */
    default void verifyThatTheLoginformIsDisplayed() {
        Assert.assertTrue(formLogin().isDisplayed(), "Форма авторизации не отображается");
    }
}


