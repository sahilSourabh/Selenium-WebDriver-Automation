import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DummySection30Upload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Setting default download directory
				ChromeOptions options =  new ChromeOptions();
				HashMap<String,Object> prefs = new HashMap<String,Object>();
				prefs.put("download.default_directory", System.getProperty("user.dir")+"\\downloads");
				options.setExperimentalOption("prefs", prefs);
				options.setAcceptInsecureCerts(true);
				
				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				driver.get("https://altoconvertpdftojpg.com");
				//Thread.sleep(2000);
				driver.findElement(By.cssSelector("#browse")).click();
				Thread.sleep(2000);
				
				//Uploading the file
				Runtime.getRuntime().exec("C:\\Users\\sahil\\OneDrive\\Documents\\fileUpload.exe");
				
				//Downloading a file
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-md-6.text-start")));
				driver.findElement(By.id("submit_btn")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Download')]")));
				driver.findElement(By.xpath("//a[contains(.,'Download')]")).click();
				
				File file = new File("S:\\Workspace\\TestAuto\\downloads\\Certificate.jpg");
				
				if(file.exists()) {
					System.out.println("File is downloaded in the directory");
					
					if(file.delete()) {
						System.out.println("File is donwloaded and Deleted");
					}
				}
				
				Thread.sleep(4000);
				driver.close();

	}

}
