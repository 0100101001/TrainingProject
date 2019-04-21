package pages.myAccountPage;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import org.assertj.core.api.Fail;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import pages.loginPage.LoginPage;

import static constants.Colors.ANSI_PURPLE;
import static constants.Colors.ANSI_RESET;
import static org.assertj.core.api.Assertions.assertThat;
import static utility.WebDriverLogger.LOGGER;

public interface MyAccountPage extends WebPage, LoginPage {

    @Name("Аватар пользователя")
    @FindBy("//div[@class= 'header-main-area']//span[@class='my-account-personal-photo-placeholder']")
    AtlasWebElement userAvatar();

    default void loginCheck() {
        SoftAssertions softAssertions = new SoftAssertions();
        try {
            softAssertions.assertThat(userAvatar().isDisplayed())
                    .as("Аватар пользователя не отображается!").isTrue();
            softAssertions.assertThat(getWrappedDriver().getCurrentUrl())
                    .as("Открыта страница авторизации!").isNotEqualTo("login");
            softAssertions.assertAll();
        } catch (NoSuchElementException e) {
            LOGGER.info(ANSI_PURPLE + "Element not found: " + ANSI_RESET + e);
            assertThat((char[]) Fail.fail(""));
        }
    }
}
