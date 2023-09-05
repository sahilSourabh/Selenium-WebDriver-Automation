
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicTableDemo {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/admin/");
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		driver.findElement(By.id("navigation")).click();
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		
		int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		System.out.println("Total number of pages are : " + total_pages);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		//WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']/li[.="+p+"]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		for (int p = 1; p <= 5; p++) {
			
			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']/li[.="+p+"]"));
			System.out.println("Active Page : " + active_page.getText());
			wait.until(ExpectedConditions.visibilityOf(active_page));
			active_page.click();
		}
		Thread.sleep(2000);
		driver.close();
	}
}
