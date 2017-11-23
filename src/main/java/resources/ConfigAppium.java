package resources;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.io.File;
import java.lang.reflect.MalformedParametersException;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ConfigAppium {

    private DesiredCapabilities cap = new DesiredCapabilities();

    public ConfigAppium() {
        String deviceName = "Nexus_5X_API_26_x86";
        String deviceType = "Android";
        
        String apkPath = "/home/lima/Documents/AGES/app-debug.apk";
        File ioApp = new File(apkPath);
        String appPath = ioApp.getAbsolutePath();
        
        setUpCap(deviceName, deviceType, appPath);
    }

    private void setUpCap(String deviceName, String deviceType, String appPath) {

        if (deviceType.equalsIgnoreCase("iOS")) {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        } else if (deviceType.equalsIgnoreCase("Android")) {
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        } else {
            throw new MalformedParametersException("Plataforma não identificada");
        }
  
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        cap.setCapability(MobileCapabilityType.APP, appPath);
        
        //cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_ID);
        //cap.setCapability(MobileCapabilityType.APP, appName);
        //cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        //cap.setCapability(MobileCapabilityType.UDID, device_ID);
        //cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10");
        //cap.setCapability(MobileCapabilityType.NO_RESET, "true");

        //cap.setCapability("unicodeKeyboard", false);
        //cap.setCapability("resetKeyboard", false);
    }

    public DesiredCapabilities getCap() {
        return this.cap;
    }
}
