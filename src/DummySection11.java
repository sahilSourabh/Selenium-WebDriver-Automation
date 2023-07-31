import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummySection11 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//COUNT NUMBER OF LINKS ON THE WEBPAGE
		//LIMITING THE SCOPE OF WEBDRIVER
		//LIMITING THE SCOPE OF WEBDRIVER TO A PARTICULAR COLUMN
		//ACCESS EACH LINK IN THE COLUMN
		//NAVIGATE TO EACH TAB AND GET THE TITLE OF EACH PAGE
		
		//1
		System.out.println(driver.findElements(By.tagName("a")).size());
		//2
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		
		WebElement footer = driver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//3
		//WebElement coldriver= footerdriver.findElement(By.xpath("//table//tbody//tr//td[1]//ul"));
		WebElement coldriver = driver.findElement(By.xpath("(//table[@class='gf-t']//td)[1]"));
		System.out.println(coldriver.findElements(By.tagName("a")).size());
		
		//4
		
		List<WebElement> colLinks = coldriver.findElements(By.xpath("//table//tbody//tr//td[1]/ul//li//a"));
		
		for(int i=1;i<colLinks.size();i++)
		{
			String keyCombo = Keys.chord(Keys.CONTROL,Keys.ENTER);
			coldriver.findElements(By.xpath("//table//tbody//tr//td[1]/ul//li//a")).get(i).sendKeys(keyCombo);
			Thread.sleep(1000);
		}
		
		//5
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext())
		{
			String id = it.next();
			driver.switchTo().window(id);
			System.out.println(driver.getTitle());
		}
		
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
