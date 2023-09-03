import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DummySection13 {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions option = new ChromeOptions();

		// Bypassing the SSL Certification on a web page
		option.setAcceptInsecureCerts(true);
		
		// PROXY
		/*Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		option.setCapability("proxy", proxy);*/

		// BLOCK POPUP WINDOWS
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

		// Cookies
		Cookie newCookie = new Cookie("myCookie", "12345");
		driver.manage().addCookie(newCookie);

		// Get and print all cookies
		System.out.println("All Cookies:");
		
		for (Cookie cookie : driver.manage().getCookies()) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}

		// Delete a specific cookie
		driver.manage().deleteCookieNamed("myCookie");

		// Verify if the cookie is deleted
		System.out.println("After deleting 'myCookie':");
		
		for (Cookie cookie : driver.manage().getCookies()) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		
		driver.manage().deleteAllCookies();

		// TAKE SCREENSHOT
		TakesScreenshot ss = (TakesScreenshot) driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,
				new File("S:\\Automation\\Automation related docs\\Selenium Web Automation\\ssfile.jpg"));

		Thread.sleep(2000);
		driver.close();

	}
}
