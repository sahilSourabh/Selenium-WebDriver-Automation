import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DummySection14WebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO 
		//Capturing webElements in a list
		//Capture text of all webElements into a new list
		//sort the original list
		//Compare Original and Sorted List
		//scan the name column for a particular item and print its price
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("thead tr th[aria-label*='Veg/fruit name")).click();
		
		List<WebElement> list = driver.findElements(By.cssSelector("tbody tr td:nth-child(1)"));
		
		List<String> orgList = list.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = orgList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(orgList.equals(sortedList));
		
		List<String> newList = list.stream().filter(s -> s.getText().contains("Almond")).map(s -> getVeggiePrice(s))
				.collect(Collectors.toList());
		newList.forEach(s->System.out.println(s));
		
		
		Thread.sleep(2000);
		driver.close();

	}
	
	private static String getVeggiePrice(WebElement s)
	{
		String itemPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return itemPrice;
		
	}

}
