import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DummySection13BrokenLinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//GET THE URL USING GET ATTRIBUTE METHOD
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		System.out.println(url);
		
		//JAVA METHODS WILL CALL THE URL AND GET THE RESPONSE CODE
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int resCode = conn.getResponseCode();
		if(resCode >400)
		{
			System.out.println("Broken Link");
		}
		else
		{
			System.out.println("Working Link");
		}
		
		
		
		
		Thread.sleep(2000);
		driver.close();

	}

}
