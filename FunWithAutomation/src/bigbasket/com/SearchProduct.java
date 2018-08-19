package bigbasket.com;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProduct {

	@Test()
	public void launchbrowserandsearchproduct() throws Exception
	{
		System.out.println("Launch Application");
		System.setProperty("webdriver.chrome.driver", "B:\\Automation\\software\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String MainProduct[] = {"Snacks & Branded Foods","Fruits & Vegetables","Fruits & Vegetables","Fruits & Vegetables"};
		String Product[] = {"Indian Mithai","Herbs & Seasonings","Fresh Vegetables","Fresh Fruits"};
		Search_FreshVegetables veg = new Search_FreshVegetables(driver);
		int counter =0;
		while(counter<4)
		{
			veg.searchdrowdownfromcatergory(MainProduct[counter], Product[counter]);	
			counter++;
		}
		driver.quit();
	}
}
