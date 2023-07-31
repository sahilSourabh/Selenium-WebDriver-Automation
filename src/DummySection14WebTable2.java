import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DummySection14WebTable2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO 
		// Scan the name column for a Particular item and print its Price
		//do Pagination and get the elements if its not present on the first page
		// Filter the element and verify if its correct
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.cssSelector("a[href='#/offers']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it  = windows.iterator();
		it.next();
		String winId = it.next();
		driver.switchTo().window(winId);
		
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		String item = "Wheat";
		List<String> itemPrice;
		do
		{
			List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
		//1.
		
			itemPrice = list.stream().filter(s -> s.getText().contains(item))
				.map(s ->s.findElement(By.xpath("following-sibling::td[1]")).getText()).collect(Collectors.toList());
			
			itemPrice.forEach(s->System.out.println(item+" Price: "+s));
		
		//2.
			if(itemPrice.size()<1)
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		}while(itemPrice.size()<1);
		
		Thread.sleep(2000);
		
		//3.
		filterItem(driver);
		
		Thread.sleep(2000);
		driver.quit();

	}
	
	public static void filterItem(WebDriver driver)
	{
		driver.findElement(By.cssSelector("#search-field")).sendKeys("rice");
		
		List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
		List<WebElement> newList = list.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(list.size(), newList.size());
		
		
	}

}
