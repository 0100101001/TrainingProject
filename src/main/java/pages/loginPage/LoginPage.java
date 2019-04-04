package pages.loginPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.NoSuchElementException;
import pages.popupMsgAndBanner.PopupMsgAndBanner;
import ru.yandex.qatools.allure.annotations.Description;

public interface LoginPage extends WebPage, PopupMsgAndBanner {

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
     * Авторизация (заполнение логина, пароля и нажатие на кнопку завершения авторизации)
     *
     * @param login    - логин пользователя
     * @param password - пароль
     */
    default void login(String login, String password) {
        closeOverlapLayer(); //закроем баннер, если появился

        inputLogin().click();
        inputLogin().clear();
        inputLogin().sendKeys(login); //ввод логина

        inputPassword().click();
        inputPassword().clear();
        inputPassword().sendKeys(password); //ввод пароля

        buttonSubmit().click(); //нажатие на кнопку завершения авторизации
    }

    /**
     * Проверка нотификации при ошибке авторизации
     *
     * @return - появилось сообщение об ошибке?
     */
    default boolean checkNotificationError() {
        try {
            return messageNotificationError().isDisplayed(); //отображается ли сообщение об ошибке
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}


