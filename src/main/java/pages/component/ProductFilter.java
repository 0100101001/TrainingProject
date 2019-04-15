package pages.component;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.plp.Plp;
import ru.yandex.qatools.allure.annotations.Description;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static utility.ActionsOnElements.scrollToElement;

public interface ProductFilter extends AtlasWebElement, Plp {

    @Description("Фильтр {{ nameFacets }}")
    @FindBy(".//form[contains(@class, 'c-plp-facets')]" +
            "//span[@data-toggle='collapse' and contains(string(), '{{ nameFacets }}')]")
    AtlasWebElement facets(@Param("nameFacets") String nameFacets);

    @Description("Фильтр {{ nameFilter }} фасета {{ nameFacets }}")
    @FindBy(".//span[@data-toggle='collapse' and contains(string(), '{{ nameFacets }}')]" +
            "//ancestor::div[@data-facet='form']//child::li[contains(string(), '{{ nameFilter }}')]//label//span")
    AtlasWebElement filter(@Param("nameFacets") String nameFacets, @Param("nameFilter") String nameFilter);

    @Description("Статус фильтра {{ nameFilter }} в фасете {{ nameFacets }}")
    @FindBy(".//span[@data-toggle='collapse' and contains(string(), '{{ nameFacets }}')]" +
            "//ancestor::div[@data-facet='form']//child::li[contains(string(), '{{ nameFilter }}')]//input")
    AtlasWebElement statusFilter(@Param("nameFacets") String nameFacets, @Param("nameFilter") String nameFilter);

    @Description("Блок с фильтрами")
    @FindBy(".//aside[contains(@class,  'o-plp-container__filters')]")
    AtlasWebElement containerFilters();


    default void toSetTheFilterInFaset(String nameFacets, String nameFilter) {
        scrollToElement(facets(nameFacets), getWrappedDriver());

        Assert.assertTrue(isOpenFacets(nameFacets), "Фасет не раскрыт!");
        Assert.assertTrue(isSelectedFilter(nameFacets, nameFilter), "Фильтр уже установлен!");

        filter(nameFacets, nameFilter).click();
        waitForTheFilter();

        Assert.assertTrue(isSelectedFilter(nameFacets, nameFilter), "Фильтр не выбран!");
    }

    default void removeTheFilterInFacets(String nameFacets, String nameFilter) {
        scrollToElement(facets(nameFacets), getWrappedDriver());

        Assert.assertTrue(isOpenFacets(nameFacets), "Фасет не раскрыт!");
        Assert.assertFalse(isSelectedFilter(nameFacets, nameFilter), "Фильтр уже снят!");

        filter(nameFacets, nameFilter).click();
        waitForTheFilter();

        Assert.assertFalse(isSelectedFilter(nameFacets, nameFilter), "Фильтр не снят!");
    }

    default void waitForTheFilter() {
        new WebDriverWait(getWrappedDriver(), 20)
                .until(ExpectedConditions.not(attributeToBe(containerFilters(),
                        "class", "o-plp-container__filters_load")));
    }

    default void isTheNumberOfItemsInTheFilterAndTheHeaderTheSame(String nameFacets, String nameFilter) {
        Assert.assertTrue(numberOfItemsInTheList().getText().contains(filter(nameFacets, nameFilter).getText()),
                "Количество товаров в фильтре и заголовке не совпадает!");
    }

    default boolean isSelectedFilter(String nameFacets, String nameFilter) {
        return !statusFilter(nameFacets, nameFilter).getAttribute("data-client-prev-action").contains("uncheck");
    }

    default boolean isOpenFacets(String nameFacets) {
        return !facets(nameFacets).getAttribute("class").contains("collapsed");
    }

    default void openFacets(String nameFacets) {
        if (isOpenFacets(nameFacets)) {
            facets(nameFacets).click();
        }
    }
}
