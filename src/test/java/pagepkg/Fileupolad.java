package pagepkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fileupolad 
{
	WebDriver driver;
	By scimport=By.xpath("//*[@id=\"importing-files\"]");
	By sccheck=By.xpath("//*[@id=\"check\"]");
	public Fileupolad(WebDriver driver) {
		this.driver=driver;
	}
	public void fileEnter() 
	{
		driver.findElement(scimport).click();
	}

	public void fileUpload(String f) throws AWTException {
		StringSelection strSelection=new StringSelection(f);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		//to paste into system window
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void check() {
		driver.findElement(sccheck).click();
	}

}
