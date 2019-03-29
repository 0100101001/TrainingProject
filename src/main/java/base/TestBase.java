package base;

import allure.MyTestListener;
import org.testng.annotations.*;

import java.io.IOException;


@Listeners(MyTestListener.class)
public class TestBase extends ApplicationManager{

  @BeforeMethod
  public void setUp() throws IOException { init();
    webDriver.navigate().refresh();
  }

  @AfterMethod
  public void tearDown() {
    stop();
  }
}
