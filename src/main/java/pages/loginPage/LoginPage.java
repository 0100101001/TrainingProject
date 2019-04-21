package pages.loginPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import org.assertj.core.api.Fail;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.NoSuchElementException;

import static constants.Colors.ANSI_PURPLE;
import static constants.Colors.ANSI_RESET;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;
import static utility.WebDriverLogger.LOGGER;

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
        try {
            MatcherAssert.assertThat("Сообщение об ошибке не отображается",
                    messageNotificationError(), displayed());
        } catch (NoSuchElementException e) {
            LOGGER.info(ANSI_PURPLE + "Element not found: " + ANSI_RESET + e);
            assertThat((char[]) Fail.fail(""));
        }
    }

    default void checkThatTheLoginPageIsOpen() {
        SoftAssertions softAssertions = new SoftAssertions();
        try {
            softAssertions.assertThat(formLogin().isDisplayed())
                    .as("Форма авторизации не отображается!").isTrue();
            softAssertions.assertThat(getWrappedDriver().getCurrentUrl())
                    .as("Страница авторизации не открыта!").contains("/login");
            softAssertions.assertAll();
        } catch (NoSuchElementException e) {
            LOGGER.info(ANSI_PURPLE + "Element not found: " + ANSI_RESET + e);
            assertThat((char[]) Fail.fail(""));
        }
    }
}


