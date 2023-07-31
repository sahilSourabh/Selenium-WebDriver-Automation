import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		String[] text = driver.findElement(By.cssSelector(".text-center.text-white")).getText().split(" ");
		// (username is rahulshettyacademy and Password is learning)
		String usrname = text[2].trim();
		String pwd = text[6].substring(0, 8);
		System.out.println(usrname + " " + pwd);

		driver.findElement(By.id("username")).sendKeys(usrname);
		driver.findElement(By.id("password")).sendKeys(pwd);

		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body")));

		driver.findElement(By.cssSelector("#okayBtn")).click();

		WebElement option = driver.findElement(By.cssSelector(".form-group select"));
		Select options = new Select(option);
		options.selectByValue("stud");

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group-item")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// SCROLL THE WINDOW
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		// driver.findElement(By.xpath("//div[@class='card-footer']/button")).click();

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='card-footer']/button"));

		for (int i = 0; i < list.size(); i++) {
			driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
		}

		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		driver.findElement(By.cssSelector(".btn.btn-success")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#country")));

		driver.findElement(By.id("country")).sendKeys("ind");

		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='suggestions']/ul/li/a"));

		for (int j = 0; j < countries.size(); j++) {
			
			String name = countries.get(j).getText();

			if (name.equalsIgnoreCase("Indonesia")) {
				driver.findElements(By.xpath("//div[@class='suggestions']/ul/li/a")).get(j).click();
				break;
			}
		}
		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#checkbox2")));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector("#checkbox2"))).click().perform();
		// driver.findElement(By.cssSelector("#checkbox2")).click();
		driver.findElement(By.cssSelector("input[value='Purchase']")).click();

		Thread.sleep(4000);
		driver.close();

	}

}
