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
import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class FavoriteTest {

    private AndroidDriver<MobileElement> driverAndroid;
    private ConfigAppium configAppium;
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
        String AppiumServerURL = "http://127.0.0.1:4723/wd/hub";

        configAppium = new ConfigAppium();
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