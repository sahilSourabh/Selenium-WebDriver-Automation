import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected()+" Checkbox checked");
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected()+" Checkbox Unchecked");
		Assert.assertFalse(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		Thread.sleep(4000);
		driver.close();
		
		
	}

}
