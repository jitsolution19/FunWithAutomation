package dainikJagran;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMethodpractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium_Project\\browserdriver\\chromedriver_win32\\chromedriver.exe");		
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		Select sel = new Select(driver.findElement(By.name("country")));
		System.out.println(sel.getFirstSelectedOption().getText());		
		sel.selectByIndex(3);
		
		
	}

}
