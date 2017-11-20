package action;

import appobjects.MenorDetalherObj;
import appobjects.VerticalListObj;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Classe que representa o fluxo a ser testado do sistema
 * @author Joao Bitelo
 */

public class HorizontalListAction {

    private AppiumDriver<MobileElement> driver;
    private VerticalListObj verticalListObj;
    private MenorDetalherObj menorDetalhes;

    public HorizontalListAction(AppiumDriver<MobileElement> driver){
        this.verticalListObj = new VerticalListObj(driver);
        this.menorDetalhes = new MenorDetalherObj(driver);
        this.driver = driver;
    }

    public void favoritarMenor() {
        verticalListObj.botaoFavoritar.click();
    }
    
    public void entrarDetalhesMenores() {
        verticalListObj.itemMenor.click();
    }
    
    public String checkName() {
    	return menorDetalhes.nomeMenor.getText();
    }
    
    public void voltaDetalhes() {
    	menorDetalhes.returnButton.click();
    }
    
}