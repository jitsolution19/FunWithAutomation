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
	public void fundamentalInfo() {
		System.out.println("Launch Application");
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_Project\\browserdriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("srchword")).clear();
		driver.findElement(By.id("srchword")).sendKeys("Power Finance");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='sugbox']")));
		for(int i=0;i<3;i++)
		{
		try
		{
		
			List<WebElement> listElement = driver.findElements(By.xpath(".//*[@id='sugbox']/div"));
			System.out.println("temp");
			Iterator<WebElement> Counter = listElement.iterator();
			System.out.println(listElement.size());
			
			while (Counter.hasNext()) {
				WebElement temp = Counter.next();
				System.out.println(temp.getText());
				if (temp.isDisplayed() && temp.getText().contains("Power Finance Corporation Ltd.")) {
					temp.click();
					break;
				} 
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		}
		
		System.out.println("Info");
		
		try
		{
			driver.findElement(By.xpath(".//*[contains(text(),'View NSE')]")).click();
			List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='div_rcard_more']/div"));
			Iterator<WebElement>counter = ele.iterator();
			while(counter.hasNext())
			{
				WebElement temp = counter.next();
				String text1 = temp.findElement(By.className("floatL")).getText();
				String text2 = temp.findElement(By.className("floatR")).getText();
				System.out.println(text1+" | "+text2);
			}
			
			
//			System.out.println(driver.findElement(By.xpath(".//table[@class='company-graph-wrap']//tr[1]")).getText());
//			System.out.println(driver.findElement(By.xpath(".//table[@class='company-graph-wrap']//tr[2]")).getText());
//			if(driver.findElement(By.xpath(".//table[@class='company-graph-wrap']")).isDisplayed())
//			{
//			System.out.println(driver.findElement(By.xpath(".//table[@class='company-graph-wrap']//tr[1]")).getText());
//			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
//		System.out.println(driver.findElement(By.xpath(".//h1[@class='f14 bold floatL']/span[@class='companyStatsTab blue curhand']")).getText());
//		if (driver.findElement(By.xpath(".//h1[@class='f14 bold floatL']/span[@class='companyStatsTab blue curhand']"))
//				.isEnabled()) {
//			String ExchangeName = driver
//					.findElement(
//							By.xpath(".//h1[@class='f14 bold floatL']/span[@class='companyStatsTab blue curhand']"))
//					.getAttribute("id");
//			if (ExchangeName == "nsetab") {
//				driver.findElement(
//						By.xpath(".//h1[@class='f14 bold floatL']/span[@class='companyStatsTab blue curhand']"))
//						.click();
//				System.out.println("Clicked");
//			}

//		}

	}
}
