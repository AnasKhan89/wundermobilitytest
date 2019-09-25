package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Page_CalculateMediaFinal {

    public Page_CalculateMediaFinal(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.exemplo.calculamediafinal:id/txtNota1']")
    private WebElement nota1;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.exemplo.calculamediafinal:id/txtNota2']")
    private WebElement nota2;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.exemplo.calculamediafinal:id/txtNota3']")
    private  WebElement nota3;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.exemplo.calculamediafinal:id/btnCalcular']")
    private WebElement calculatorBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.exemplo.calculamediafinal:id/txtMediaFinal']")
    private WebElement resultTxt;

}
