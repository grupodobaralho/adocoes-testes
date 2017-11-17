package appobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


/**
 *
 * @author thiago.nascimento@acad.pucrs.br
 * Classe dos objetos operados no login do App, criada com AppiumFieldDecorator.
 * Para maiores informações, consultar documentação oficial:
 * {link: https://appium.github.io/java-client/io/appium/java_client/pagefactory/AppiumFieldDecorator.html}
 */

public class TermosObj {

    /**
     * @param driver {link appium.github.io/java-client/io/appium/java_client/AppiumDriver.html}
     * @author thiago.nascimento@acad.pucrs.br
     */

    public TermosObj(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/termos_layout")
    public MobileElement telaTermos;
            
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/checkbox")
    public MobileElement termosCheck;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/btn_termos")
    public MobileElement botaoAvancarTermos;
}