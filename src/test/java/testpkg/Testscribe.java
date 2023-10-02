package testpkg;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import basepkg.Baseclass;
import pagepkg.Fileupolad;
import pagepkg.Loginpagedatadriven;
import pagepkg.Mouseover;
import pagepkg.Windowhandling;
import utilitypkg.Excelutilsribens;

public class Testscribe extends Baseclass
{
	
	
		@Test
		public void testrun() throws AWTException, InterruptedException, IOException 
		{
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			Loginpagedatadriven log=new Loginpagedatadriven(driver);
			driver.navigate().refresh();
			log.loginclick();
			String xl="C:\\Users\\radhu\\OneDrive\\Desktop//scribelogindatadriven.xlsx";
			String sheet="Sheet1";
			int rowCount=Excelutilsribens.getRowCount(xl, sheet);
			
			for(int i=1;i<=rowCount;i++) 
			{
				String email=Excelutilsribens.getCellValue(xl,sheet,i,0);
				System.out.println("emailid---"+email);
				String password=Excelutilsribens.getCellValue(xl,sheet,i,1);
				System.out.println("password---"+password);
				Thread.sleep(2000);
				log.details(email, password);
				log.clicksigning();
				
			}
			driver.navigate().refresh();
			Mouseover mh=new Mouseover(driver);
			mh.click();
			WebElement specialchara=mh.hover();
			Actions act=new Actions(driver);
			act.moveToElement(specialchara);
			act.perform();
			Thread.sleep(3000);
			Fileupolad fu=new Fileupolad(driver);
			fu.fileEnter();
			fu.fileUpload("C:\\Users\\radhu\\Downloads\\ASSIGNMENT selenium radhika (1).pdf");
			Thread.sleep(5000);
			fu.check();
			Thread.sleep(3000);
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenshot,new File("./scribescreenshort.png"));
			Windowhandling wh=new Windowhandling(driver);
			String parentWindow=driver.getWindowHandle();
			System.out.println("Parent Window Title:"+driver.getTitle());
			wh.field();
			Thread.sleep(3000);
			Set<String> allWindowHandles=driver.getWindowHandles();
			for(String handles:allWindowHandles) {
				System.out.println(handles);
				if(!handles.equalsIgnoreCase(parentWindow)) {
					driver.switchTo().window(handles);
					Thread.sleep(3000);
					wh.dictpage();
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,500)", "");
					Thread.sleep(5000);
					driver.close();
				}
				
				driver.switchTo().window(parentWindow);
			}
			}

}
