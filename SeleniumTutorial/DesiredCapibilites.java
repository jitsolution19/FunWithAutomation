import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapibilites {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","E:\\Selenium_Project\\browserdriver\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		WebDriver driver = new FirefoxDriver(capabilities);
		System.out.println("getPlatform== "+capabilities.getPlatform());
		System.out.println("getVersion == "+capabilities.getVersion());
		System.out.println("getBrowserName== "+capabilities.getBrowserName());
		driver.navigate().to("https://timesofindia.indiatimes.com/");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		System.out.println("Done");
	}

}
