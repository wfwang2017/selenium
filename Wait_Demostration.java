package myMavenProject;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Demostration {

	// created reference variable for WebDriver
	WebDriver driver;
	@BeforeTest
	public void setup() throws InterruptedException {

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Wang\\Desktop\\Selenium_training\\firefoxDriver\\geckodriver.exe");   


		// initializing driver variable using FirefoxDriver
		driver=new FirefoxDriver();
		// launching gmail.com on the browser
		driver.get("https://gmail.com");
		// maximized the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void waitDemoTest() throws InterruptedException {

		// saving the GUI element reference into a "username" variable of WebElement type
		WebElement username = driver.findElement(By.id("identifierId"));	
		

		// entering username
		username.sendKeys("wangwenfeng2017@gmail.com");
		
		WebElement nextButton = driver.findElement(By.cssSelector("span.RveJvd.snByac"));
		nextButton.click();

		// entering password
		driver.findElement((By.name("password"))).sendKeys("Wang2017");

		// clicking signin button
		WebElement nextButtonPw = driver.findElement(By.cssSelector("span.RveJvd.snByac"));
		nextButtonPw.click();

		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver,30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
	}

	@AfterTest
	public void teardown() {
		// closes all the browser windows opened by web driver
		driver.quit(); 
		System.out.println("Test WaitDemoTest executed successfully.");
	}
}
