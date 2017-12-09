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
		// Nome relativo ao celular ou emulador que ira executar o aplicativo
		String deviceName = "Samsung SM-G920I";
		// Indica se eh aplicativo Android ou iOS (apenas testado com Android)
		String deviceType = "Android";

		// Caminho que leva ate a APK do aplicativo
		String apkPath = "";
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

		// Caso o appium nao consiga encontrar a primeira activity
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
