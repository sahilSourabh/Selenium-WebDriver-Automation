import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DummySection30 {

	public static void main(String[] args) throws InterruptedException {
		
		String directory = System.getProperty("user.dir");
		
		//Setting up Default Download Directory
		ChromeOptions options = new ChromeOptions();
		HashMap<String,Object> prefs = new HashMap<String,Object>();
		prefs.put("download.default_directory", directory+"\\downloads");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://demo.imacros.net/Automate/Downloads");
		driver.findElement(By.linkText("Download")).click();
		
		File file =  new File("D:\\Sourabh\\Workspace\\Dummy-Sel\\downloads\\Download.zip");
		
		if(file.exists()) {
			System.out.println("File is found in the Project Directory");
			if(file.delete())
			{
				System.out.println("File is found and Deleted");
			}
		}
		
//		Thread.sleep(4000);
//		driver.close();
		

	}

}
