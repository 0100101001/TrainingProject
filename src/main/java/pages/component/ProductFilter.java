package pages.component;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import io.qameta.atlas.webdriver.extension.Param;
import org.assertj.core.api.Fail;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.plp.Plp;

import static constants.Colors.ANSI_PURPLE;
import static constants.Colors.ANSI_RESET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static utility.ActionsOnElements.scrollToElement;
import static utility.WebDriverLogger.LOGGER;

public interface ProductFilter extends AtlasWebElement, Plp {

    @Name("Фильтр {{ nameFacets }}")
    @FindBy(".//form[contains(@class, 'c-plp-facets')]" +
            "//span[@data-toggle='collapse' and contains(string(), '{{ nameFacets }}')]")
    AtlasWebElement facets(@Param("nameFacets") String nameFacets);

    @Name("Фильтр {{ nameFilter }} фасета {{ nameFacets }}")
    @FindBy(".//span[@data-toggle='collapse' and contains(string(), '{{ nameFacets }}')]" +
            "//ancestor::div[@data-facet='form']//child::li[contains(string(), '{{ nameFilter }}')]//label//span")
    AtlasWebElement filter(@Param("nameFacets") String nameFacets, @Param("nameFilter") String nameFilter);

    @Name("Статус фильтра {{ nameFilter }} в фасете {{ nameFacets }}")
    @FindBy(".//span[@data-toggle='collapse' and contains(string(), '{{ nameFacets }}')]" +
            "//ancestor::div[@data-facet='form']//child::li[contains(string(), '{{ nameFilter }}')]//input")
    AtlasWebElement statusFilter(@Param("nameFacets") String nameFacets, @Param("nameFilter") String nameFilter);

    @Name("Блок с фильтрами")
    @FindBy(".//aside[contains(@class,  'o-plp-container__filters')]")
    AtlasWebElement containerFilters();


    default void toSetTheFilterInFaset(String nameFacets, String nameFilter) {
        scrollToElement(facets(nameFacets), getWrappedDriver());

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(isOpenFacets(nameFacets)).as("Фасет не раскрыт!").isTrue();
        softAssertions.assertThat(isSelectedFilter(nameFacets, nameFilter))
                .as("Фильтр уже установлен!").isTrue();
        softAssertions.assertAll();

        filter(nameFacets, nameFilter).click();
        waitForTheFilter();

        assertThat(isSelectedFilter(nameFacets, nameFilter)).as("Фильтр не выбран!").isTrue();
    }

    default void removeTheFilterInFacets(String nameFacets, String nameFilter) {
        scrollToElement(facets(nameFacets), getWrappedDriver());

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(isOpenFacets(nameFacets)).as("Фасет не раскрыт!").isTrue();
        softAssertions.assertThat(isSelectedFilter(nameFacets, nameFilter)).as("Фильтр уже снят!").isFalse();
        softAssertions.assertAll();

        filter(nameFacets, nameFilter).click();
        waitForTheFilter();

        assertThat(isSelectedFilter(nameFacets, nameFilter)).as("Фильтр не снят!").isFalse();
    }

    default void waitForTheFilter() {
        new WebDriverWait(getWrappedDriver(), 20)
                .until(ExpectedConditions.not(attributeToBe(containerFilters(),
                        "class", "o-plp-container__filters_load")));
    }

    default void isTheNumberOfItemsInTheFilterAndTheHeaderTheSame(String nameFacets, String nameFilter) {
        try {
            assertThat(numberOfItemsInTheList().getText().trim())
                    .as("Количество товаров в фильтре и заголовке не совпадает!")
                    .isEqualTo(filter(nameFacets, nameFilter).getText().trim());
        } catch (NoSuchElementException e) {
            LOGGER.info(ANSI_PURPLE + "Element not found: " + ANSI_RESET + e);
            assertThat((char[]) Fail.fail(""));
        }
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
