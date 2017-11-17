package appobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class VerticalListObj {

    public VerticalListObj(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/btn_favoritar")
    public MobileElement botaoFavoritar;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/rl_cell")
    public MobileElement itemMenor;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/tv_nome")
    public MobileElement nomeMenor;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Crianças e Adolescentes']")
    public MobileElement listagemTitulo;
}
