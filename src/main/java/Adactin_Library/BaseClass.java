package Adactin_Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	protected WebDriver driver;
	public void initializeBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com");
	}

}
