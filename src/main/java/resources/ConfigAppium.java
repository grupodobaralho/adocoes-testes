package resources;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ConfigAppium {

    private DesiredCapabilities cap = new DesiredCapabilities();

    public ConfigAppium(String device, String tipoDevice, String appName) {
        setUpCap(device, tipoDevice, appName);
    }

    private DesiredCapabilities setUpCap(String device_ID, String tipoDevice, String appName) {
/*
        if (tipoDevice.equalsIgnoreCase("iOS")) {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        } else if (tipoDevice.equalsIgnoreCase("Android")) {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        } else {
            throw new MalformedParametersException("Plataforma não identificada");
        }
*/  
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_ID);
        cap.setCapability(MobileCapabilityType.APP, appName);
        
        //cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_ID);
        //cap.setCapability(MobileCapabilityType.APP, appName);
        //cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        //cap.setCapability(MobileCapabilityType.UDID, device_ID);
        //cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10");
        //cap.setCapability(MobileCapabilityType.NO_RESET, "true");

        //	cap.setCapability("unicodeKeyboard", false);
        //	cap.setCapability("resetKeyboard", false);
        return cap;
    }

    public DesiredCapabilities getCap() {
        return this.cap;
    }
}
