package verticalList;

import action.HorizontalListAction;
import action.LoginAction;
import action.TermosAction;
import action.VerticalListAction;
import resources.ConfigAppium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class OpenListaVertical {

    private AppiumDriver<MobileElement> driver;
    private AndroidDriver<MobileElement> driverAndroid;
    private ConfigAppium configAppium;
//Android Emulator - Nexus_5X_API_26_x86:5554
//@Parameters({"DEVICE_ID", "AppiumServerURL", "DeviceType", "appName"})
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
    	String device_ID = "Samsung SM-G920I";//"Nexus_5X_API_26_x86";
        String AppiumServerURL = "http://127.0.0.1:4723/wd/hub";

        String apkPath = "C:\\Users\\16111210\\Desktop\\adocoes-android\\adocoes-android\\app\\build\\outputs\\apk\\debug\\app-debug.apk";//"/home/lima/Documents/AGES/app-debug.apk";
        File ioApp = new File(apkPath);
        String appName = ioApp.getAbsolutePath();
        String deviceType = "Android";
        //String appName = "adocoes-android";
        configAppium = new ConfigAppium(device_ID, deviceType, appName);
        this.driverAndroid = new AndroidDriver<MobileElement>(new URL(AppiumServerURL), configAppium.getCap());
        
        LoginAction loginDriver = new LoginAction(driverAndroid);
        loginDriver.entrarSemLogin();
        
        TermosAction termosDriver = new TermosAction(driverAndroid);
        termosDriver.aceitarTermos();
    }

    @Test
    public void testMenorSelect() throws InterruptedException {
    	VerticalListAction verticalListDriver = new VerticalListAction(driverAndroid);
        verticalListDriver.entrarDetalhesMenores();
        String NomeTest = verticalListDriver.checkMenorNome();
        driverAndroid.navigate().back();
        verticalListDriver.changeScreen();
        HorizontalListAction horizontalListDriver = new HorizontalListAction(driverAndroid);
        String nomeTest2 = horizontalListDriver.checkMenorNomeHorizontal();
        Assert.assertEquals(NomeTest.toUpperCase(), nomeTest2.toUpperCase());
    }
}