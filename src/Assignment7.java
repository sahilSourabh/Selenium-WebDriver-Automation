import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// PRINT TOTAL NUMBER OF ROWS AND COLUMNS IN THE TABLE
		// PRINT THE DATA OF THE SECOND ROW OF THE TABLE

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// 1
		List<WebElement> listRows = driver.findElements(By.cssSelector("table[name='courses'] tr"));
		List<WebElement> listColumns = driver.findElements(By.cssSelector("table[name='courses'] tr th"));
		System.out.println(listRows.size());
		System.out.println(listColumns.size());

		// 2
		
		//List<WebElement> rowData = driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(3)"));
		System.out.println(driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(3)")).getText());

//		for (int i = 0; i < rowData.size(); i++) {
//			System.out.println(
//					driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(3)")).get(i).getText());
//		}
		//rowData.stream().map(s->s.getText()).forEach(s->System.out.println(s));

		Thread.sleep(2000);
		driver.close();

	}

}
