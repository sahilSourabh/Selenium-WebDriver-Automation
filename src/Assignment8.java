import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("united");
		List<WebElement> list = driver.findElements(By.cssSelector(".ui-menu-item"));
		
//		for(WebElement country:list)
//		{
//			if(country.getText().equalsIgnoreCase("United States (USA)"))
//			{
//				Actions option = new Actions(driver);
//				option.moveToElement(country).click().perform();
//			}
//		}
		
		
		Actions option = new Actions(driver);
		option.moveToElement(driver.findElement(By.xpath("//ul[@id='ui-id-1']//li[contains(.,'US')]"))).build()
				.perform();
		Thread.sleep(1000);
		option.moveToElement(driver.findElement(By.xpath("//ul[@id='ui-id-1']//li[contains(.,'US')]"))).click()
		.perform();
		
		
		
		
		
		
		
		Thread.sleep(2000);
		driver.close();

	}

}
