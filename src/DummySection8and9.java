import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DummySection8and9 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//Explicit wait Declaration
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//Select multiple items
		//convert array into arrayList for easy search
		//check whether name you extracted is present in arrayList or not
		//Add items to cart
		//Verify how many times code is running inside loop for break statement
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		int count=0;
		String[] items = { "Carrot", "Beetroot", "Cucumber", "Tomato" };

		// driver.findElement(By.xpath("//div//h4[contains(.,'Cauliflower')]/following-sibling::div/button")).click();
		List<WebElement> products = driver
				.findElements(By.cssSelector("div[class='product'] h4[class='product-name']"));

		for (int i = 0; i < products.size(); i++) {
			
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List<String> itemsToAdd = Arrays.asList(items);

			

			if (itemsToAdd.contains(formattedName)) {
				
				count++;
				//Selecting Quantity for each veggie
				for(int j=1;j<3;j++)
				{
					driver.findElements(By.cssSelector("a[class='increment']")).get(i).click();
				}
				driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
				
				if(count==items.length)
				{
					break;
				}
			}
				
		}
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[.='PROCEED TO CHECKOUT']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div input[class='promoCode']")));
		// PLACING ORDER PAGE
		driver.findElement(By.cssSelector("div input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("span[class='promoInfo']")).getText(),
				"Code applied ..!");
		driver.findElement(By.xpath("//button[.='Place Order']")).click();

		WebElement options = driver.findElement(By.xpath("//label/following-sibling::div/select"));
		Select option = new Select(options);
		option.selectByValue("India");

		// T&C PAGE
		driver.findElement(By.cssSelector("input[type*='checkbox']")).click();
		driver.findElement(By.xpath("//button[.='Proceed']")).click();

		Thread.sleep(4000);
		driver.close();
	}

}
