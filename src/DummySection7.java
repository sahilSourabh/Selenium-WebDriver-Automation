import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DummySection7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// AutoSuggestiveDropdowns
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("(//ul[@id='ui-id-1']/li/a)[1]")).getText());
		// driver.findElement(By.xpath("(//ul[@id='ui-id-1']/li/a)[2]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));

		for (WebElement option : list) {
			if (option.getText().equalsIgnoreCase("India")) 
			{
				option.click();
				break;
			}
		}
		
		//CountTheCheckBoxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		//CheckBoxes
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
		
		
		
		// StaticDropdown
		WebElement staticDropdown = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
		Select options = new Select(staticDropdown);
		options.selectByIndex(2);
		System.out.println(options.getFirstSelectedOption().getText());
		options.selectByValue("INR");
		System.out.println(options.getFirstSelectedOption().getText());
		options.selectByVisibleText("USD");
		System.out.println(options.getFirstSelectedOption().getText());

		Thread.sleep(2000);

		// UpdatedDropdown
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		int i = 1;
		while (i < 3) {
			driver.findElement(By.id("hrefIncChd")).click();
			i++;
		}

		for (int j = 1; j < 5; j++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.xpath("//div[@class='ad-row align-center']/input")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// DynamicDropdown
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[contains(.,' Chennai (MAA)')]")).click();
		//driver.findElement(By.xpath("(//a[.=' Bengaluru (BLR)'])[2]")).click();
		// instead of using Index based traversing we can use Parent to Child relationship to locate identifiers
		driver.findElement(By.xpath(
				"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//li" + "//a[.=' Bengaluru (BLR)']"))
				.click();
		
		//CalenderUI
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		//UIElements Validation(Disabled or not)
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		
		if(driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Enabled");
		}
		else
		{
			System.out.println("Disabled");
		}
		
		
		
		

		Thread.sleep(4000);
		driver.close();

	}

}
