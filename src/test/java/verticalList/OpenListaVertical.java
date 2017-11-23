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

    private AndroidDriver<MobileElement> driverAndroid;
    private ConfigAppium configAppium;
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
        String AppiumServerURL = "http://127.0.0.1:4723/wd/hub";

        configAppium = new ConfigAppium();
        this.driverAndroid = new AndroidDriver<MobileElement>(new URL(AppiumServerURL), configAppium.getCap());
        
        LoginAction loginDriver = new LoginAction(driverAndroid);
        loginDriver.entrarSemLogin();
        
        TermosAction termosDriver = new TermosAction(driverAndroid);
        termosDriver.aceitarTermos();
    }

    @Test
    public void testMenorSelect() throws InterruptedException {
    	VerticalListAction verticalListDriver = new VerticalListAction(driverAndroid);
        HorizontalListAction horizontalListDriver = new HorizontalListAction(driverAndroid);
        
        verticalListDriver.entrarDetalhesMenores();
        String nomeNaListaVertical = verticalListDriver.checkMenorNome();
        
        driverAndroid.navigate().back();
        verticalListDriver.changeScreen();
        
        String nomeNaListaHorizontal = horizontalListDriver.checkMenorNomeHorizontal();
        Assert.assertEquals(nomeNaListaVertical.toUpperCase(), nomeNaListaHorizontal.toUpperCase());
    }
}