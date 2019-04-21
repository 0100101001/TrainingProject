package pages.plp;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import org.assertj.core.api.Fail;
import org.openqa.selenium.NoSuchElementException;

import static constants.Colors.ANSI_PURPLE;
import static constants.Colors.ANSI_RESET;
import static org.assertj.core.api.Assertions.assertThat;
import static utility.WebDriverLogger.LOGGER;

public interface Plp extends WebPage {

    @Name("Заголовок страницы")
    @FindBy(".//div[@class = 'c-plp-heading__title']//h1")
    AtlasWebElement plpHeadingTitle();

    @Name("Количество товаров в списке")
    @FindBy(".//span[@class = 'c-plp-heading__count']")
    AtlasWebElement numberOfItemsInTheList();

    default void checkThatTheExpectedPageIsOpen(String titleName) {
        try {
            assertThat(plpHeadingTitle().getText().trim())
                    .as("Открытая страница не содержит ожидаемый заголовок.").isEqualTo(titleName);
        } catch (NoSuchElementException e) {
            LOGGER.info(ANSI_PURPLE + "Element not found: " + ANSI_RESET + e);
            assertThat((char[]) Fail.fail(""));
        }
    }

}
