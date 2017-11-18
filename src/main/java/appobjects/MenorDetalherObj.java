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

public class MenorDetalherObj {

    /**
     * @param driver {link appium.github.io/java-client/io/appium/java_client/AppiumDriver.html}
     * @author thiago.nascimento@acad.pucrs.br
     */

    public MenorDetalherObj(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/menor_details_layout")
    public MobileElement telaMenorDetalhes;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/nome_text_view")
    public MobileElement menorNome;

	@AndroidFindBy(id="br.pucrs.ages.adocoes:id/tv_nome")
    public MobileElement menorNomeHorizontal;
}