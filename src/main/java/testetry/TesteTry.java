/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testetry;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author lima
 */
public class TesteTry {

    /**
     * @param args the command line arguments
     * @throws InterruptedException
     */
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Caminho ate apk -> deve ser buildada
        String apkPath = "/home/lima/Documents/AGES/App.apk";
        // Nome do device
        String deviceName = "Android Emulator - Nexus_5X_API_26_x86:5554";

        File ioApp = new File(apkPath);
        DesiredCapabilities dCap = new DesiredCapabilities();
        dCap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dCap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        dCap.setCapability(MobileCapabilityType.APP, ioApp.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dCap);

        //abre app
        driver.findElement(By.xpath("//android.widget.FrameLayout")).click();
        //abre menu
        driver.findElement(By.xpath("//android.widget.ImageButton")).click();

        // Usando Touch Action Classes - scroll down
        scrollDown(driver);

        //entra na listagem horizontal
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Listagem Horizontal']")).click();
        testeHorizontal(driver);

        //entra na listagem vertical
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Listagem Vertical']")).click();
        testeVertical(driver);

        System.out.println("fim");
    }

    private static void testeVertical(AndroidDriver driver) {
        testeTrocadeTela(driver, "br.pucrs.ages.adocoes:id/troca_para_horizontal");
        driver.findElement(By.xpath("//android.widget.ImageButton")).click();
        testeFavoritou(driver);

    }

    public static void testeHorizontal(AndroidDriver driver) {
        //driver.findElement(By.id("//android.support.v7.widget.LinearLayoutCompat")).click();
        //driver.findElement(By.id("//br.pucrs.ages.adocoes:id/btn_favoritar")).click();
        //junit.framework.Assert.assertEquals("Favoritou ", driver.findElement(By.id("//br.pucrs.ages.adocoes:id/btn_favoritar")).getText());
        //abre menu
        testeTrocadeTela(driver, "br.pucrs.ages.adocoes:id/troca_para_vertical");
        driver.findElement(By.xpath("//android.widget.ImageButton")).click();
        testeFavoritou(driver);

    }

    private static void testeTrocadeTela(AndroidDriver driver, String nomeBotao) {
        driver.findElement(By.id(nomeBotao)).click();

    }

    private static void testeFavoritou(AndroidDriver driver) {
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Favoritos']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton")).click();

    }

    private static void scrollDown(AndroidDriver driver) {
        TouchAction tAction = new TouchAction(driver);
        int startx = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Favoritos']")).getLocation().getX();
        int starty = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Favoritos']")).getLocation().getY();
        int endx = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Termos de Uso']")).getLocation().getX();
        int endy = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Termos de Uso']")).getLocation().getY();
        //System.out.println(startx + " ::::::: " + starty + " ::::::: " + endx +  " ::::::: " +	endy);

        //necessario implementar teste
        //while(!isVisible("//android.widget.CheckedTextView[@text='Listagem Horizontal']", driver)) {
        tAction.longPress(endx, endy).moveTo(startx, starty).release().perform();
        tAction.longPress(endx, endy).moveTo(startx, starty).release().perform();

    }

    private static boolean isVisible(String string, AndroidDriver driver) {
        try {
            driver.findElement(By.xpath(string)).click();
            return true;
        } catch (NoSuchElementException e) {

            return false;
        }
    }
}
