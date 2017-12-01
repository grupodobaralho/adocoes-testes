package verticalList;

import action.HorizontalListAction;
import action.LoginAction;
import action.TermosAction;
import action.VerticalListAction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.Test;

public class OpenListaVertical {

	private AndroidDriver<MobileElement> driverAndroid;

	public OpenListaVertical(AndroidDriver<MobileElement> driverAndroid) throws InterruptedException {
		this.driverAndroid = driverAndroid;
		testMenorSelect();
	}

	@Test
	public void testMenorSelect() throws InterruptedException {
		LoginAction loginDriver = new LoginAction(driverAndroid);
		loginDriver.entrarSemLogin();

		TermosAction termosDriver = new TermosAction(driverAndroid);
		termosDriver.aceitarTermos();
		VerticalListAction verticalListDriver = new VerticalListAction(driverAndroid);
		HorizontalListAction horizontalListDriver = new HorizontalListAction(driverAndroid);

		verticalListDriver.entrarDetalhesMenores();
		String nomeNaListaVertical = verticalListDriver.checkMenorNome();

		driverAndroid.navigate().back();
		verticalListDriver.changeScreen();

		String nomeNaListaHorizontal = horizontalListDriver.checkMenorNomeHorizontal();
		Assert.assertEquals(nomeNaListaVertical.toUpperCase(), nomeNaListaHorizontal.toUpperCase());
	}
}