package allure;

import base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

public class MyTestListener implements ITestListener {
  @Override
  public void onTestStart(ITestResult iTestResult) {

  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
//    TestBase testBase = (TestBase) iTestResult.getTestContext().getAttribute("Base");
    saveScreenshot();
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  private byte[] saveScreenshot() {
    return ((TakesScreenshot) TestBase.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }

//  @Attachment(value = "Page screenshot", type = "image/png")
//  public byte[] saveScreenshot(byte[] screenShot) {
//    return screenShot;
//  }

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
