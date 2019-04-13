package pages.plp;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Description;

public interface Plp extends WebPage {

    @Description("Заголовок страницы")
    @FindBy(".//div[@class = 'c-plp-heading__title']//h1")
    AtlasWebElement plpHeadingTitle();

    @Description("Количество товаров в списке")
    @FindBy(".//span[@class='c-plp-heading__count']")
    AtlasWebElement numberOfItemsInTheList();

    default void checkThatTheProductListPageIsOpen(String titleName) {
        Assert.assertTrue(plpHeadingTitle().getText().contains(titleName));
    }

}
