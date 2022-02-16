import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_tc_3 extends base {

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
		
		
		// Parent to child
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
		for (int i = 0; i<count;i++) 
		{	
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if(text.equals("Jordan 6 Rings")) 
			{
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
			
			
		}
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();

	}

}
