import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.cssSelector("li a[href$='/windows']")).click();
		driver.findElement(By.cssSelector("div a[href$='/windows/new']")).click();
		
		Set<String> windows =  driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
