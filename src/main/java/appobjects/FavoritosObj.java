package appobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class FavoritosObj {

    public FavoritosObj(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/rv_favoritos")
    public MobileElement telaFavoritos;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/rl_cell")
    public MobileElement checkMenor;

	@AndroidFindBy(id="br.pucrs.ages.adocoes:id/tv_nome")
    public MobileElement menorNome;

	@AndroidFindBy(id="br.pucrs.ages.adocoes:id/btn_favoritar")
    public MobileElement desfavoritarMenor;

	@AndroidFindBy(id="android:id/button1")
    public MobileElement desfavoritarMenorConfir;
    
}
