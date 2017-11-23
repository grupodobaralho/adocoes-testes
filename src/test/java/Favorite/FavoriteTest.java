package Favorite;

import action.FavoritesAction;
import action.LoginAction;
import action.MenuAction;
import action.TermosAction;
import action.VerticalListAction;
import resources.ConfigAppium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import static org.testng.Assert.assertEquals;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class FavoriteTest {

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
        
    }

    @Test
    public void testfavoritarSemLogin() throws InterruptedException {
        LoginAction loginDriver = new LoginAction(driverAndroid);
        loginDriver.entrarSemLogin();
        
        TermosAction termosDriver = new TermosAction(driverAndroid);
        termosDriver.aceitarTermos();
        
        VerticalListAction verticalListDriver = new VerticalListAction(driverAndroid);
        MenuAction Menu = new MenuAction(driverAndroid);
        FavoritesAction Favoritos = new FavoritesAction(driverAndroid);
        
        /* Para aumentar a precisao do teste, e necessario limpar a lista de favoritos antes, esqueleto abaixo
        verticalListDriver.abreMenu();
        Menu.entrarListaInteresses();
        Assert.assertEquals(null, Favoritos.checkMenorExist());
        verticalListDriver.abreMenu();
        Menu.entrarListaMenores();*/
        verticalListDriver.favoritarMenor();
        verticalListDriver.entrarDetalhesMenores();
        String nomeTest1 = verticalListDriver.checkMenorNome();
        driverAndroid.navigate().back();
        
        verticalListDriver.abreMenu();
        Menu.entrarListaInteresses();
        String nomeTest2 = Favoritos.checkMenorNome();
        Assert.assertEquals(nomeTest1.toUpperCase(), nomeTest2.toUpperCase());
        
        //comando para desfazer a alteracao feita, visto que acoes nas listagem de favortiso e permanente
        Favoritos.desfavoritarMenor();
        Favoritos.desfavotitarMenorConfirm();
        
    }
}