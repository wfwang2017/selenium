package myMavenProject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * class description
 */

public class DemoWebAlert {
	WebDriver driver;
	/**
	 * Constructor
	 */
	public DemoWebAlert() {                            
	}

	/**
	 * Set up browser settings and open the application
	 */

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Wang\\Desktop\\Selenium_training\\firefoxDriver\\geckodriver.exe");   

		driver=new FirefoxDriver();
		// Opened the application
		driver.get("file:///C:/Users/Wang/Desktop/Selenium_training/dropdown.html");
		driver.manage().window().maximize();
	}

	/**
	 * Test to check Select functionality
	 * @throws InterruptedException
	 */

	@Test
	public void testWebAlert() throws InterruptedException {                          
		// clicking on try it button
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		Thread.sleep(5000);

		// accepting javascript alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// clicking on try it button
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		Thread.sleep(5000);

		// accepting javascript alert
		driver.switchTo().alert().dismiss();

		// clicking on try it button
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		Thread.sleep(5000);

		// accepting javascript alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	/**
	 * Tear down the setup after test completes
	 */

	@AfterTest
	public void tearDown() {             
		driver.quit();
	}
}