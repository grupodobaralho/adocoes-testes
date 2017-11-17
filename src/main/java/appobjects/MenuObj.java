package appobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class MenuObj {

    public MenuObj(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    public MobileElement openMenu;
    
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Crianças e Adolescentes']")
    public MobileElement menuListaMenores;
    
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Listagem de Interesses']")
    public MobileElement menuListaFavoritos;
    
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Novidades']")
    public MobileElement menuNovidades;
    
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Sobre']")
    public MobileElement menuSobre;
    
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Logout']")
    public MobileElement menuLogout;
}
