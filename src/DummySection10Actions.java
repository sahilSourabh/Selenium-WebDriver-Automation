import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DummySection10Actions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");

		Actions action = new Actions(driver);
		// PERFORMING MOUSEOVER
		action.moveToElement(driver.findElement(By.cssSelector("#icp-nav-flyout"))).build().perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		// RIGHT CLICK ON PAGE
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		// TYPE IN CAPS IN A TEXTBOX
		action.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("pan").build().perform();
		// SELECT THE TEXT IN THE TEXTBOX
		action.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).doubleClick().build()
				.perform();
		
		//TO NAVIGATE TO DIFFERENT WINDOWS
		driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		
		//String username = driver.findElement(By.cssSelector("a[href*='mail']")).getText();
		String username = driver.findElement(By.cssSelector(".im-para.red a")).getText();
		
		System.out.println(driver.findElement(By.cssSelector("a[href*='mail']")).getText());
		driver.switchTo().window(parentWindow);
		
		action.moveToElement(driver.findElement(By.id("username"))).click().keyUp(Keys.SHIFT).sendKeys(username).build()
				.perform();
		//driver.findElement(By.id("username")).sendKeys(username);
		
		Thread.sleep(4000);
		driver.quit();

	}

}
