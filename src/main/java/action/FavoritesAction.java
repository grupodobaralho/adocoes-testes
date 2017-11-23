package action;

import appobjects.FavoritosObj;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Classe que representa o fluxo a ser testado do sistema
 * @author Thiago Carreira A. Nascimento
 */

public class FavoritesAction {

    private AppiumDriver<MobileElement> driver;
    private FavoritosObj favoritosObj;

    public FavoritesAction(AppiumDriver<MobileElement> driver){
        this.favoritosObj = new FavoritosObj(driver);
        this.driver = driver;
    }

    public MobileElement checkMenorExist() {
        return favoritosObj.checkMenor;
    }
    
    public String checkMenorNome() {
    	return favoritosObj.menorNome.getText();
    }

	public void desfavoritarMenor() {
		favoritosObj.desfavoritarMenor.click();
		
	}

	public void desfavotitarMenorConfirm() {
		favoritosObj.desfavoritarMenorConfir.click();
		
	}
    

}