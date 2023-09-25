package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_Home 
{
	@FindBy(xpath="//input[@name='username_show']")private WebElement userShow;
	@FindBy(xpath="//a[text()='Logout']")private WebElement logoutBtn;
	
	@FindBy(xpath="//a[text()='Click here to login again']")private WebElement loginAgain;
	
	public Adactin_Home(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getUsername()
	{
		String str=userShow.getAttribute("value");
		
		String a1[]=str.split(" ");
		
		String uname=a1[1];
		return(uname);
		
	}
	public void clickLogoutBtn()
	{
		logoutBtn.click();
	}
	
	public void clickloginAgain()
	{
		loginAgain.click();
	}
}
