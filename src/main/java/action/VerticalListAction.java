package action;

import appobjects.VerticalListObj;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Classe que representa o fluxo a ser testado do sistema
 * @author Thiago Carreira A. Nascimento
 */

public class VerticalListAction {

    private AppiumDriver<MobileElement> driver;
    private VerticalListObj verticalListObj;

    public VerticalListAction(AppiumDriver<MobileElement> driver){
        this.verticalListObj = new VerticalListObj(driver);
        this.driver = driver;
    }

    public void favoritarMenor() {
        verticalListObj.botaoFavoritar.click();
    }
    
    public void entrarDetalhesMenores() {
        verticalListObj.itemMenor.click();
    }
    
    public String checkTitulo() {
        return verticalListObj.listagemTitulo.getText();
    }


    /**
     * Método para baixar o teclado nativo do Android. Será realocado para outra
     * classe de extensions.
     
    public void hideKeyboard() {
        ((AndroidDriver) driver).pressKeyCode(4);
    }*/
}