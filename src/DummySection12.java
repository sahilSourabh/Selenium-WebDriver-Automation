import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DummySection12 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// SCROLL THE WEBPAGE
		// SCROLL TO A PARTICULAR TABLE OF A WEBPAGE
		// PRINT THE SUM OF THE COLUMN VALUES OF THE TABLE
		// COMPARING COUNTED SUM vs PRINTED SUM
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);

		// 2
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// 3
		int sum = 0;
		List<WebElement> list = driver.findElements(By.cssSelector(".tableFixHead table tr td:nth-child(4)"));

		for (int i = 0; i < list.size(); i++) 
		{
			int num = Integer.parseInt(
					driver.findElements(By.cssSelector(".tableFixHead table tr td:nth-child(4)")).get(i).getText());
			sum = sum + num;
		}
		System.out.println("Counted sum: " + sum);

		// 4
		int printedSum = Integer
				.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println("Printed sum: " + printedSum);
		Assert.assertEquals(sum, printedSum);

		Thread.sleep(2000);
		driver.close();

	}

}