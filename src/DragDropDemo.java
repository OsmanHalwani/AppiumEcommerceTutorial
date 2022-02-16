import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;

import static java.time.Duration.ofSeconds;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragDropDemo extends base{

	public static void main(String[] args) throws MalformedURLException  {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilites();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		TouchAction t = new TouchAction(driver);
		//longpress(source / move /// release(destination)
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement des = driver.findElementsByClassName("android.view.View").get(1);
		t.longPress(longPressOptions().withElement(element (source))).moveTo(element(des)).release().perform();
	

	}

}
