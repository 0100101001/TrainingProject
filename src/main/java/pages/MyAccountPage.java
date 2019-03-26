package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends TestBase {

  /**
   * Аватар
   */
  @FindBy(xpath = "//div[@class= 'header-main-area']//span[@class='my-account-personal-photo-placeholder']")
  WebElement userAvatar;


  public MyAccountPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    waitForPageLoad(webDriver);
    PageFactory.initElements(webDriver,this);
  }
}
