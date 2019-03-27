package allure;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class MyTestListener implements ITestListener {

  private static ThreadLocal<WebDriver> localThreadDriver = new ThreadLocal<WebDriver>();

  public synchronized static void setDriver(WebDriver driver){
    localThreadDriver.set(driver);
  }

  public static WebDriver getDriver(){
    return localThreadDriver.get();
  }

  @Override
  public void onTestStart(ITestResult iTestResult) {

  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    saveScreenshot(tekeScreenshot(getDriver()));
  }

  public byte[] tekeScreenshot(WebDriver webDriver) {

    if (webDriver != null) {
      return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }else {
      try {
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(screenShot, "png", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
      } catch (Exception e) {
        return new byte[]{};
      }
    }
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

  }

  @Override
  public void onStart(ITestContext iTestContext) {

  }

  @Override
  public void onFinish(ITestContext iTestContext) {

  }
}
