package rediffMoney;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StockInfo {

	@Test
	public void fundamentalInfo()
	{
		System.out.println("Launch Application");
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_Project\\browserdriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://money.rediff.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("srchword")).sendKeys("Power Finance Corporation Ltd");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@id='sugbox']/div")));
		List<WebElement> listElement=driver.findElements(By.xpath(".//*[@id='sugbox']/div"));
		Iterator<WebElement> Counter = listElement.iterator();
		while(Counter.hasNext())
		{
			WebElement temp = Counter.next();			
			if(temp.getText().contains("Power Finance Corporation Ltd"))
			{
				temp.click();
				System.out.println("Clicked Successfully");
				break;				
			}
		}
		
		if(driver.findElement(By.xpath(".//h1[@class='f14 bold floatL']/span")).isDisplayed())
		{
			String ExchangeName = driver.findElement(By.xpath(".//h1[@class='f14 bold floatL']/span")).getAttribute("id");
			if(ExchangeName=="nsetab")
			{
				driver.findElement(By.xpath(".//h1[@class='f14 bold floatL']/span")).click();
				System.out.println("Clicked");
			}
			
			}
		
	}
}
