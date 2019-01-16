package sqlPractice;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CustomerTable {

	@Test
	public void numberofRecord() throws InvalidSelectorException
	{
		System.out.println("Launch Application");
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_Project\\browserdriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.findElement(By.className("CodeMirror-code")).clear();
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.cssSelector("pre.CodeMirror-line")));
		builder.sendKeys(Keys.DELETE);
		builder.click();
		builder.sendKeys("SELECT * FROM Customers;");
		builder.build().perform();
		driver.findElement(By.xpath(".//button[@class='w3-green w3-btn']")).click();
	}
}
