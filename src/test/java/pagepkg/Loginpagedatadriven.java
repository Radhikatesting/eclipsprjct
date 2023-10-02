package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpagedatadriven 
{
	WebDriver driver;
	By sclogin=By.xpath("//*[@id=\"btncn\"]");
	By scemail=By.xpath("//*[@id=\"inputIdC\"]");
	By scpassword=By.xpath("//*[@id=\"inputMdpC\"]");
	By scsign=By.xpath("//*[@id=\"se-connecter-blocks\"]/td[1]/div[4]");
	public Loginpagedatadriven(WebDriver driver) {
		this.driver=driver;
	}
	public void loginclick() {
		driver.findElement(sclogin).click();
	}
	public void details(String email,String password) {
		driver.findElement(scemail).clear();
		driver.findElement(scemail).sendKeys(email);
		driver.findElement(scpassword).clear();
		driver.findElement(scpassword).sendKeys(password);
	}
	public void clicksigning() {
		driver.findElement(scsign).click();
	}

}
