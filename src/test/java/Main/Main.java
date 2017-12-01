package Main;

import resources.ConfigAppium;
import verticalList.OpenListaVertical;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import favorites.FavoritesTest;
import java.net.MalformedURLException;
import login.LoginTest;
import org.testng.annotations.AfterMethod;

public class Main {

    private AndroidDriver<MobileElement> driverAndroid;
    private ConfigAppium configAppium;
    // Android Emulator - Nexus_5X_API_26_x86:5554
    // @Parameters({"DEVICE_ID", "AppiumServerURL", "DeviceType", "appName"})

    @BeforeTest
    public void setUp() throws MalformedURLException {
        configAppium = new ConfigAppium();
        configAppium.configAppium();
        configAppium.configAndroidDriver();
        this.driverAndroid = configAppium.getAndroidDriver();
    }

    @AfterMethod
    public void resetApp() {
        driverAndroid.resetApp();
    }

    @Test
    public void testLogin() throws InterruptedException {
        LoginTest testLogin = new LoginTest(driverAndroid);
    }

    @Test
    public void testList() throws InterruptedException {
        OpenListaVertical listTest = new OpenListaVertical(driverAndroid);
    }

    @Test
    public void testFavoritos() throws InterruptedException {
        FavoritesTest testFavorites = new FavoritesTest(driverAndroid);
    }

}
