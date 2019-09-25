package CalculateMediaTestCases;

import CalculateMedia.Base;
import CalculateMedia.TestData;
import PageObjects.Page_CalculateMediaFinal;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCases extends Base {


    //@Test(dataProvider="testData" , dataProviderclass = TestData.class)

    @Test(dataProvider = "testData",dataProviderClass =TestData.class )
    public void testCase1(TestData testData) throws IOException, InterruptedException {
        service=startServer();
        AndroidDriver<AndroidElement> driver=capabilities("appName");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        Page_CalculateMediaFinal pgCalculate = new Page_CalculateMediaFinal(driver);
        pgCalculate.getNota1().sendKeys(testData.getField1());
        pgCalculate.getNota2().sendKeys(testData.getField2());

    }
}
