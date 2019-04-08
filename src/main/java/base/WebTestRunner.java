package base;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.NetworkHelper;

import java.io.IOException;

public class WebTestRunner extends ApplicationManager {

    private Configuration configuration = ConfigFactory.create(Configuration.class, System.getProperties());

    @BeforeMethod
    public void setUp() throws IOException {
        /* Проверим код ответа сервера */
        NetworkHelper networkHelper = new NetworkHelper();
        networkHelper.getStatusCodeOfServer(configuration.siteUrl());

        init();
    }

    @AfterMethod
    public void tearDown() {
        stop();
    }

    /**
     * Переход по url
     */
    public void goToWebsite() {
        webDriver.get(configuration.siteUrl());
    }
}
