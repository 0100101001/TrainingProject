package utility;

import org.testng.Assert;

import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Utility {

  /**
   * Проверка кода ответа сервера
   * @param address - url
   * @throws IOException - исключение
   */
  public void getStatusCodeOfServer(String address) throws IOException {
    URL url = new URL(address);
    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
    httpURLConnection.setRequestMethod("GET");
    httpURLConnection.connect();
    int statusCode = httpURLConnection.getResponseCode();

    System.out.println("Server response code: " + statusCode);
    Assert.assertEquals(statusCode,200, "Server response code: " + statusCode);
  }

  public String getProperties(String keyProperty) {
    String property;

    Path propertyFile = Paths.get("src/test/resources/application.properties");
    try {
      Files.lines(propertyFile, Charset.forName("UTF-8"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    Properties properties = new Properties();
    Reader PropReader = null;

    try {
      PropReader = Files.newBufferedReader(propertyFile);
      properties.load(PropReader);
    } catch (IOException e) {
      e.printStackTrace();
    }
    property = properties.getProperty(keyProperty);

    try {
      if (PropReader != null) {
        PropReader.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return property;
  }

//  /**
//   * Снятие скриншота
//    * @param webDriver - экземпляр драйвера
//   * @return - возвращает массив байтов
//   */
//  public byte[] tekeScreenshot(WebDriver webDriver) {
//    return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
//  }
}
