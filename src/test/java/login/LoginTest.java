package login;

import action.LoginAction;
import action.TermosAction;
import action.VerticalListAction;
import resources.ConfigAppium;
import verticalList.OpenListaVertical;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import junit.framework.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

    private AndroidDriver<MobileElement> driverAndroid;
    private ConfigAppium configAppium;
    //Android Emulator - Nexus_5X_API_26_x86:5554
    //@Parameters({"DEVICE_ID", "AppiumServerURL", "DeviceType", "appName"})

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String AppiumServerURL = "http://127.0.0.1:4723/wd/hub";

        configAppium = new ConfigAppium();
        this.driverAndroid = new AndroidDriver<MobileElement>(new URL(AppiumServerURL), configAppium.getCap());
    }
    
    @AfterMethod
    public void resetApp() {
        driverAndroid.resetApp();
    }    
    
    @Test
    public void testEntrarSemLogin_ComTermos() throws InterruptedException {
        LoginAction loginDriver = new LoginAction(driverAndroid);
        TermosAction termosDriver = new TermosAction(driverAndroid);
        VerticalListAction verticalListDriver = new VerticalListAction(driverAndroid);
        
        loginDriver.entrarSemLogin();
        termosDriver.aceitarTermos();
        
        Assert.assertEquals("Crianças e Adolescentes", verticalListDriver.checkTitulo());
    }
    
    @Test
    public void testEntrarComLogin_ComTermos() throws InterruptedException {
        LoginAction loginDriver = new LoginAction(driverAndroid);
        TermosAction termosDriver = new TermosAction(driverAndroid);
        VerticalListAction verticalListDriver = new VerticalListAction(driverAndroid);
        
        loginDriver.entrarComLogin();
        termosDriver.aceitarTermos();
        
        Assert.assertEquals("Crianças e Adolescentes", verticalListDriver.checkTitulo());
    }
    
    //@Test Login depois que os termos pararem de aparecer
    public void testEntrarComLogin_SemTermos() throws InterruptedException {
        LoginAction loginDriver = new LoginAction(driverAndroid);
        
        loginDriver.entrarComLogin();
    }
    
    //@Test Login depois que os termos pararem de aparecer
    public void testEntrarSemLogin_SemTermos() throws InterruptedException {
        LoginAction loginDriver = new LoginAction(driverAndroid);
        
        loginDriver.entrarSemLogin();
    }
}
