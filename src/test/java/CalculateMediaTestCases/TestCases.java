package CalculateMediaTestCases;

import CalculateMedia.TestData;
import org.testng.annotations.Test;

public class TestCases {

    //@Test(dataProvider="testData" , dataProviderclass = TestData.class)

    @Test(dataProvider = "testData",dataProviderClass =TestData.class )
    public void testCase1(TestData testData){

        System.out.println(testData.getField1());

    }
}
