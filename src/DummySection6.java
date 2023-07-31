import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummySection6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// SiblingTraversal
		System.out
				.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		// ChildToParent
		System.out.println(driver
				.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/div/button[2]")).getText());

		// Browser Navigations
		driver.navigate().to("https://rahulshettyacademy.com/documents-request");
		Thread.sleep(1000);
		driver.navigate().back();
		driver.navigate().forward();

		Thread.sleep(2000);
		driver.close();

	}

}
