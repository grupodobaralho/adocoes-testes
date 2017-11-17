package action;

import appobjects.LoginObj;
import appobjects.TermosObj;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TermosAction {

    private final AppiumDriver<MobileElement> driver;
    private final TermosObj termosObj;

    public TermosAction(AppiumDriver<MobileElement> driver) {
        this.termosObj = new TermosObj(driver);
        this.driver = driver;
    }

    public void aceitarTermos() {
        termosObj.termosCheck.click();
        termosObj.botaoAvancarTermos.click();
    }
}
