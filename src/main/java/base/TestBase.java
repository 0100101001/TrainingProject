package base;

import allure.MyTestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(MyTestListener.class)
public class TestBase extends ApplicationManager {

    @BeforeMethod
    public void setUp() throws IOException {
        init();
//    webDriver.navigate().refresh();
    }

    @AfterMethod
    public void tearDown() {
        stop();
    }
}
