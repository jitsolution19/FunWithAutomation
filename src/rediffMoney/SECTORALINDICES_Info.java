package rediffMoney;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SECTORALINDICES_Info {

	@Test()
	public void sectoralIndices_information() {
		System.out.println("Launch Application");
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_Project\\browserdriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://money.rediff.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());		
		List<WebElement> sectorindices = driver.findElements(By.xpath(".//*[@class='div_secto_tabs']//b"));		
		Iterator<WebElement> ele = sectorindices.iterator();
		System.out.println("Sector Indices are as : ");
		while (ele.hasNext()) {
			WebElement temp = ele.next();
			if (temp.isDisplayed() && temp.isEnabled()) {
				System.out.print(temp.getText()+" | ");
				System.out.print(temp.findElement(By.xpath("following-sibling::h5")).getText()+ " | ");				
				System.out.print(temp.findElement(By.xpath("following-sibling::h6")).getText()+" | ");
				System.out.print(temp.findElement(By.xpath("following-sibling::h6")).getAttribute("class"));
				System.out.println();
			}
		}

		driver.close();

	}
}
