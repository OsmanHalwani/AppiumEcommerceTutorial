import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class browse extends baseChrome {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

			
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		driver.findElement(By.cssSelector("a[href*='products']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,1000", "");
		
		String text = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();
		
		Assert.assertEquals(text, "Devops");
		
		
		

}
}
