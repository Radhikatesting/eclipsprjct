package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Baseclass 
{
		public WebDriver driver;
		@BeforeTest
		public void browser()
		{
			driver=new EdgeDriver();
		}
		@BeforeMethod
		public void urlload() 
		{
			driver.get("https://www.scribens.com/#");
		}
	}

