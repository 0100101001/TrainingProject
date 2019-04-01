package pages.popupMsgAndBanner;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.NoSuchElementException;
import ru.yandex.qatools.allure.annotations.Description;

public interface PopupMsgAndBanner extends WebPage {

  /**
   *Перекрывающий блок, при появлении баннера или всплывающего сообщения
   */
  @Description("Перекрывающий блок")
  @FindBy("//div[@class='flocktory-widget-overlay' and @data-vivaldi-spatnav-clickable='1']")
  AtlasWebElement overlapLayer();


  /**
   * Закрытие всплывающих сообщений и баннеров, если отображаются
   */
  default void closeOverlapLayer() {
    try {
      if (overlapLayer().isDisplayed()) { //если отображается, то закроем
        overlapLayer().click();
      }
    } catch (NoSuchElementException ignored) {

    }
  }
}
