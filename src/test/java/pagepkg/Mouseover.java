package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Mouseover 
{
	WebDriver driver;
	By sctools=By.xpath("//*[@id=\"actions\"]/p");
	By scspecialchara=By.xpath("//*[@id=\"specialchars\"]");
	public Mouseover(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void click() 
	{
		driver.findElement(sctools).click();
	}
	public WebElement hover() 
	{
		 return driver.findElement(scspecialchara);
	}

}
