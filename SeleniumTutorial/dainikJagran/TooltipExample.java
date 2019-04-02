package dainikJagran;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TooltipExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_Project\\browserdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/test/tooltip.html");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		String expectedTooltip = "What's new in 3.2";

		WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));
		Actions builder = new Actions(driver);

		builder.clickAndHold().moveToElement(download);
		builder.moveToElement(download).build().perform();

		WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
		String actualTooltip = toolTipElement.getText();

		System.out.println("Actual Title of Tool Tip  " + actualTooltip);
		if (actualTooltip.equals(expectedTooltip)) {
			System.out.println("Test Case Passed");
		}
		driver.close();

	}

}
