package CalculateMediaTestCases;

import CalculateMedia.Base;
import CalculateMedia.TestData;
import PageObjects.Page_CalculateMediaFinal;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCases extends Base {

    @Test(priority = 1, dataProvider = "testData",dataProviderClass =TestData.class,
          description = "verify that application is calculating average of all 3 fields")
    public void testCase1(TestData testData) throws IOException, InterruptedException {

        Page_CalculateMediaFinal pgCalculate = new Page_CalculateMediaFinal(driver);
        pgCalculate.getNota1().sendKeys(testData.getField1());
        pgCalculate.getNota2().sendKeys(testData.getField2());
        pgCalculate.getNota3().sendKeys(testData.getField3());
        pgCalculate.getCalculatorBtn().click();
        Double expResult=20.0;
        Assert.assertEquals((Double.valueOf(pgCalculate.getResultTxt().getText())),expResult);
    }

    @Test(priority = 2, dataProvider = "testData",dataProviderClass =TestData.class,
            description = "verify that application is perform correctly when user only fill 2 fields and calculate them")
    public void testCase2(TestData testData) throws IOException, InterruptedException {

        Page_CalculateMediaFinal pgCalculate = new Page_CalculateMediaFinal(driver);
        pgCalculate.getNota1().sendKeys(testData.getField1());
        pgCalculate.getNota2().sendKeys(testData.getField2());
       // pgCalculate.getNota3().sendKeys(testData.getField3());
        pgCalculate.getCalculatorBtn().click();
        Double expResult= 10.0;
        try {
            Assert.assertEquals(Double.valueOf(pgCalculate.getResultTxt().getText()),expResult);
        }
        catch(Exception e)
        {
            System.out.println("Application is not perform correctly"); //I assume that application should show average of 2 fields
            Assert.fail(e.getMessage());
        }

    }
}
