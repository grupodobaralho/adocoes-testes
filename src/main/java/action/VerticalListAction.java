package action;

import appobjects.MenorDetalherObj;
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
    private MenorDetalherObj menorDetalhe;

    public VerticalListAction(AppiumDriver<MobileElement> driver){
        this.verticalListObj = new VerticalListObj(driver);
        this.driver = driver;
        this.menorDetalhe = new MenorDetalherObj(driver);
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
    
    public String checkMenorNome() {
        return menorDetalhe.menorNome.getText();
    }
    
    public void changeScreen() {
    	verticalListObj.changeScreen.click();
    }

	public void abreMenu() {
		verticalListObj.abreMenu.click();
		
	}


    /**
     * Método para baixar o teclado nativo do Android. Será realocado para outra
     * classe de extensions.
     
    public void hideKeyboard() {
        ((AndroidDriver) driver).pressKeyCode(4);
    }*/
}