package myMavenProject;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoWindowAlert {
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Wang\\Desktop\\Selenium_training\\firefoxDriver\\geckodriver.exe");   

		driver=new FirefoxDriver();
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
	}

	@Test
	public void testWindowAlert() throws Exception{

		// saving the GUI element reference into a "username" variable of WebElement type
		WebElement username = driver.findElement(By.id("identifierId"));	


		// entering username
		username.sendKeys("wangwenfeng2017@gmail.com");

		WebElement nextButton = driver.findElement(By.cssSelector("span.RveJvd.snByac"));
		nextButton.click();

		// entering password
		WebElement password = driver.findElement(By.name("password"));

		password.clear();

		password.sendKeys("Wang2017");

		// clicking signin button
		WebElement nextButtonPw = driver.findElement(By.cssSelector("span.RveJvd.snByac"));
		nextButtonPw.click();
		
		Thread.sleep(30000);

		// click on compose button
		driver.findElement(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")).click();

		// click on attach files icon
		driver.findElement(By.xpath("//div[contains(@command,'Files')]//div[contains(@class,'aaA')]")).click();

		// creating instance of Robot class (A java based utility)
		Robot rb =new Robot();

		// pressing keys with the help of keyPress and keyRelease events
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_SEMICOLON);
		rb.keyRelease(KeyEvent.VK_SEMICOLON);
		rb.keyRelease(KeyEvent.VK_SHIFT);

		rb.keyPress(KeyEvent.VK_BACK_SLASH);
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_P);
		rb.keyRelease(KeyEvent.VK_P);

		rb.keyPress(KeyEvent.VK_I);
		rb.keyRelease(KeyEvent.VK_I);

		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("Test testWindowAlert executed successfully.");
	}
}

