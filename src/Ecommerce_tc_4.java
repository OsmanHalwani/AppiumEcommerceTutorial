import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
public class Ecommerce_tc_4 extends base {

	public static void main(String[] args) throws MalformedURLException {
		
		
		AndroidDriver<AndroidElement> driver = capabilites();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		driver.findElementByAndroidUIAutomator("text(\"Argentina\")").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
		double price1 = Double.parseDouble(driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText().substring(1));
		double price2 = Double.parseDouble(driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText().substring(1));
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		double total = Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));

		double sum = price1 + price2;
		System.out.println(sum);
		System.out.println(total);
		Assert.assertEquals(sum, total);
		
	
		//mobile gesters
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		WebElement tc = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElementById("android:id/button1").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
		
		

	}
	
	public static double getAmount(String value) {
		value = value.substring(1);
		double trueValue = Double.parseDouble(value);
		return trueValue;
		
	}

}
