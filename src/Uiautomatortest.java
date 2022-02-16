

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Uiautomatortest extends base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement>driver = capabilites();
	//	driver.findElementByAndroidUIAutomator("attribute(value)");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		//Validate clickable in the list of views
		// driver.findElementsByAndroidUIAutomator(" new UiSelector().property(true)");
		int r = driver.findElementsByAndroidUIAutomator(" new UiSelector().clickable(true)").size();
		
	}

}
