package utility;

import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

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
}
