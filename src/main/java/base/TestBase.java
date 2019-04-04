package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

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
