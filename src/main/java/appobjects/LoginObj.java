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

public class LoginObj {

    /**
     * @param driver {link appium.github.io/java-client/io/appium/java_client/AppiumDriver.html}
     * @author thiago.nascimento@acad.pucrs.br
     */

    public LoginObj(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/entrar_sem_cadastro_button")
    public MobileElement botaoEntrarSemLogin;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/entrar_com_cadastro_button")
    public MobileElement botaoEntrarComLogin;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/email_edit_text")
    public MobileElement campoEmailLogin;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/senha_edit_text")
    public MobileElement campoSenhaLogin;
    
    @AndroidFindBy(id="br.pucrs.ages.adocoes:id/esqueceu_senha")
    public MobileElement campoEsqueceuSenha;
}