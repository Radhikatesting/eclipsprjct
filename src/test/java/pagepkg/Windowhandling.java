package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Windowhandling 
{
	WebDriver driver;
	By gramerrules=By.xpath("//*[@id=\"btnreg\"]");
	By scdict=By.xpath("//*[@id=\"btndict\"]");
	public Windowhandling(WebDriver driver) {
		this.driver=driver;
	}
	public void field() {
		driver.findElement(gramerrules).click();
	}
	public void dictpage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.findElement(scdict).click();
	}
}
