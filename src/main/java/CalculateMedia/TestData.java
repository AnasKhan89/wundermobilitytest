package CalculateMedia;
import org.testng.annotations.DataProvider;

public class TestData {
    private String field1;
    private String field2;
    private String field3;


    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField1() {
        return field1;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @DataProvider(name="testData")
    public static Object[][] userTestData () {
        //Code to read from file/xml
        TestData testData = new TestData();
        testData.setField1("10");
        testData.setField2("20");
        testData.setField3("30");

        return new Object[][] {{testData}};
    }


}
