package action;

import appobjects.MenuObj;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Classe que representa o fluxo a ser testado do sistema
 * @author Thiago Carreira A. Nascimento
 */

public class MenuAction {

    private AppiumDriver<MobileElement> driver;
    private MenuObj menuObj;

    public MenuAction(AppiumDriver<MobileElement> driver){
        this.menuObj = new MenuObj(driver);
        this.driver = driver;
    }

    public void abrirMenu() {
        menuObj.openMenu.click();
    }
    
    public void entrarListaMenores() {
        menuObj.menuListaMenores.click();
    }
    
    public void entrarListaInteresses() {
        menuObj.menuListaFavoritos.click();
    }
    
    public void entrarNovidades() {
        menuObj.menuNovidades.click();
    }

    public void entrarSobre() {
        menuObj.menuSobre.click();
    }
    
    public void fazerLogout() {
        menuObj.menuLogout.click();
    }

    /**
     * Método para baixar o teclado nativo do Android. Será realocado para outra
     * classe de extensions.
     
    public void hideKeyboard() {
        ((AndroidDriver) driver).pressKeyCode(4);
    }*/
}