package CalculateMedia;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;

    @BeforeMethod
    public void SetUp() throws IOException, InterruptedException
    {
        //taskkill /F /IM node.exe
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);
        service=startServer();
        AndroidDriver<AndroidElement> driver=capabilities("appName");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown(){
        service.stop();
    }


    public AppiumDriverLocalService startServer()
    {

        boolean flag = checkIfServerIsRunnning(4723);
        if(!flag)
        {
            service= AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException
    {

        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\global.properties");
        Properties prop=new Properties();
        prop.load(fis);

        File appDir = new File("src");
        File app = new File(appDir, (String) prop.get(appName));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String device=(String) prop.get("deviceName");

    /* if(device.contains("emulator"))
     {
         startEmulator();
     }*/
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static void startEmulator() throws IOException, InterruptedException
    {

        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat - Shortcut");
        Thread.sleep(6000);

    }


}
