package dainikJagran;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RightClickOperation {

	@Test
	public void rightclick()
	{
		System.setProperty("webdriver.gecko.driver","E:\\Selenium_Project\\browserdriver\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("Marionette", false);
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.navigate().to("https://www.jagran.com/");
		Actions builder = new Actions(driver);
		builder.contextClick().sendKeys(Keys.ARROW_UP).click();
		builder.build().perform();
	}
}
