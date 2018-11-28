import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TempCode {

	@Test()
	public void tempsearch()
	{
		System.out.println("Launch Application");
		System.setProperty("webdriver.chrome.driver",
				"E:\\Selenium_Project\\browserdriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/companies/Power-Finance-Corporation-Ltd/14040029?srchword=Power+Finance+Corporation+Ltd.&snssrc=sugg");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try
		{
			driver.findElement(By.xpath(".//*[contains(text(),'View NSE')]")).click();
						
			WebElement screenshotelement = driver.findElementById("nseChart");
			
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", screenshotelement);
//			Thread.sleep(500);
			
			Actions action = new Actions(driver); 
			action.moveToElement(screenshotelement).perform();
			
			Thread.sleep(5000);
			
			File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImage = ImageIO.read(screenshot);
			
			// Get the location of element on the page
			Point point = screenshotelement.getLocation();
			System.out.println(point.getX()+"  || "+point.getY());
			// Get width and height of the element
			int eleWidth = screenshotelement.getSize().getWidth();
			int eleHeight = screenshotelement.getSize().getHeight();
			System.out.println("eleWidth "+eleWidth+" | eleHeight "+eleHeight);
//			System.out.println(fullImage.getTileGridXOffset());
			System.out.println("Height "+fullImage.getHeight()+" Width "+fullImage.getWidth());
			System.out.println(fullImage.getRaster());
			
//			fullImage.getSubimage(eleHeight, eleWidth,point.getX(), point.getY());
			
			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot= fullImage.getSubimage(point.getX(),480,eleWidth,eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);
			
			File DstFile = new File("E:\\Selenium_Project\\screenshot\\temp2.png");
			FileUtils.copyFile(screenshot, DstFile);			
//			driver.close();
//			List<WebElement> companygraphinfo = driver.findElements(By.xpath(".//table[@class='company-graph-wrap']//tr"));
//			Iterator<WebElement>counter_companygraphinfo = companygraphinfo.iterator();
//			
//			while(counter_companygraphinfo.hasNext())
//			{
//				WebElement temp = counter_companygraphinfo.next();				
//				if(temp.isDisplayed()&&temp.isEnabled())
//				{
//				System.out.println(temp.getText());
//				}
//			}
			
//			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
