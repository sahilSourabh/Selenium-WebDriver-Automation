import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummySection15 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO 
		// Relative Locators Practice
		// Navigate to AngularPractice URL.
		// Fill the 'Name' field with the first course available at rahulshettyacademy.
		// Take Partial Screenshot of the WebElement of 'Name' field after entering data
		// Capture Height and Width of the NameBox
		
		WebDriver driver = new ChromeDriver();
		relativeLocators(driver);
		Thread.sleep(2000);
		//2.
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//3.
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/");
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		
		System.out.println("First Course Name: "+courseName);
		
		driver.switchTo().window(parentId);
		WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
		nameBox.sendKeys(courseName);
		
		//4.
		File src = nameBox.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("logo.jpg"));
		FileUtils.copyFile(src, new File("D:\\Sourabh\\Selenium Automation\\logo.jpg"));
		
		//5.
		System.out.println("Height: "+nameBox.getRect().getDimension().getHeight());
		System.out.println("Width: "+nameBox.getRect().getDimension().getWidth());
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	//1.
	public static void relativeLocators(WebDriver driver)
	{
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameBox = driver.findElement(By.cssSelector(".form-control.ng-pristine"));
		driver.findElement(with(By.tagName("label")).above(nameBox));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameBox)).getText());
		
		WebElement dob = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		WebElement checkboxLabel = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxLabel)).click();
		
		WebElement radioLabel = driver.findElement(By.xpath("//label[.='Student']"));
		driver.findElement(with(By.tagName("input")).toRightOf(radioLabel)).click();
		
		
	}

}
