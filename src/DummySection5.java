import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummySection5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String passWord= PassWord(driver);
		String name = "Sahil";
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(passWord);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		
		
		
		Thread.sleep(3000);
		driver.close();
		

	}
	
	public static String PassWord(WebDriver driver) throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Sahil");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Sahil@123");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("7010300074");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());
		String[] pass= driver.findElement(By.cssSelector(".infoMsg")).getText().split("'");
		//Please use temporary password 'rahulshettyacademy' to Login.
		//String passWord = pass[1].trim();
		String passWord = pass[1].split("'")[0];
		return passWord;
		
	}

}
