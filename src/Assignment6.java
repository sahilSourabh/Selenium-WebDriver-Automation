import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.Select a checkbox and print its label
		//2.Select option in Dropdown same which you selected in checkbox
		//3.Enter the grabbed text in editbox
		//4.Click on Alert and verify if grabbed text displayed in pop up 
		
		
		//1
		//driver.findElement(By.id("checkBoxOption2")).click();
		driver.findElement(By.cssSelector("label[for='benz'] input")).click();
		String optionSelected = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		System.out.println(optionSelected);
		
		//2
		WebElement option = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select options = new Select(option);
		options.selectByVisibleText(optionSelected);
		
		//3
		driver.findElement(By.id("name")).sendKeys(optionSelected);
		
		//4
		driver.findElement(By.id("alertbtn")).click();
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		//String selectedOption = text.split(" ")[1].substring(0, 7);
		//Assert.assertEquals(selectedOption, "Option2");
		Thread.sleep(2000);
		if(text.contains(optionSelected))
		{
			System.out.println("Alert message success");
		}
		else
		{
			System.out.println("Something wrong with execution");
		}
		
		driver.switchTo().alert().accept();
		
		
		Thread.sleep(2000);
		driver.close();

	}

}
