package dainikJagran;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ReadHeadlines {

	@Test()
	public void readHeadline()
	{
		System.setProperty("webdriver.gecko.driver","E:\\Selenium_Project\\browserdriver\\geckodriver-v0.22.0-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("Marionette", false);
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.navigate().to("https://www.jagran.com/");
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		System.out.println("Done");
		
		List<WebElement> element = driver.findElements(By.xpath(".//*[@class='newsBox']//a"));
		Iterator<WebElement> tempcounter = element.iterator();
		while(tempcounter.hasNext())
		{
			WebElement count = tempcounter.next();
			if(count.isDisplayed()&&count.isEnabled())
			{
				System.out.println(count.getText());
				writedata(count.getText());
			}
			
		}
		
	}
	
	public void writedata(String text)
	{
		try {
			FileWriter tempfile = new FileWriter(new File("E:\\Selenium_Project\\database\\newsfeed.txt"),true);
			BufferedWriter write = new BufferedWriter(tempfile);
			write.newLine();
			write.write(text);
			write.close();
			tempfile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
