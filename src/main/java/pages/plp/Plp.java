package pages.plp;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import org.testng.Assert;

public interface Plp extends WebPage {

    @Name("Заголовок страницы")
    @FindBy(".//div[@class = 'c-plp-heading__title']//h1")
    AtlasWebElement plpHeadingTitle();

    @Name("Количество товаров в списке")
    @FindBy(".//span[@class = 'c-plp-heading__count']")
    AtlasWebElement numberOfItemsInTheList();

    default void checkThatTheProductListPageIsOpen(String titleName) {
        Assert.assertTrue(plpHeadingTitle().getText().contains(titleName));
    }

}
