package pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface MyAccountPage extends WebPage {

  @FindBy("//div[@class= 'header-main-area']//span[@class='my-account-personal-photo-placeholder']")
  AtlasWebElement userAvatar();
}
