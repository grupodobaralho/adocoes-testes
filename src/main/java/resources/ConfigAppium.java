package resources;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.io.File;
import java.lang.reflect.MalformedParametersException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class ConfigAppium {

	private DesiredCapabilities cap = new DesiredCapabilities();
	private AndroidDriver<MobileElement> driverAndroid;
	private int active =0;

	public ConfigAppium() {
	}

	public void configAppium() {
		String deviceName = "Samsung SM-G920I";
		// "Nexus_5X_API_26_x86";
		String deviceType = "Android";

		String apkPath = "C:\\Users\\16111210\\Desktop\\adocoes-android\\adocoes-android\\app\\build\\outputs\\apk\\debug\\app-debug.apk";
		// "/home/lima/Documents/AGES/app-debug.apk";
		File ioApp = new File(apkPath);
		String appPath = ioApp.getAbsolutePath();

		setUpCap(deviceName, deviceType, appPath);
		
		active = 1;
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

		// encontrado o problema
		// o appium nao conseguia encontrar a primeira activity
		cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "br.pucrs.ages.adocoes.*");

	}

	public DesiredCapabilities getCap() {
		return this.cap;
	}

	public void configAndroidDriver() throws MalformedURLException {
		String AppiumServerURL = "http://127.0.0.1:4723/wd/hub";
		driverAndroid = new AndroidDriver<MobileElement>(new URL(AppiumServerURL), getCap());
	}

	public AndroidDriver<MobileElement> getAndroidDriver() {
		return this.driverAndroid;
	}
	
	public int getStatusServer() {
		return active;
	}
}
