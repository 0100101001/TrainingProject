package pages.myAccountPage;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Waits;

public class MyAccountPage extends TestBase {

  /**
   * Аватар
   */
  @FindBy(xpath = "//div[@class= 'header-main-area']//span[@class='my-account-personal-photo-placeholder']")
  public WebElement userAvatar;


  public MyAccountPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver,this);
  }
}
