package action;

import appobjects.LoginObj;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginAction {

    private final AppiumDriver<MobileElement> driver;
    private final LoginObj loginObj;

    public LoginAction(AppiumDriver<MobileElement> driver) {
        this.loginObj = new LoginObj(driver);
        this.driver = driver;
    }

    public void entrarSemLogin() {
        loginObj.botaoEntrarSemLogin.click();
    }
    
    public void entrarComLogin() {
        loginObj.campoEmailLogin.sendKeys("interessado01@adocoes.ages.pucrs.br");
        loginObj.campoSenhaLogin.sendKeys("a123456");
        //driver.hideKeyboard();
        loginObj.botaoEntrarComLogin.click();
    }
    
    //loginObj.signInTextField.setValue(this.user);
}
