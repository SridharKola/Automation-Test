package eggtimer;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class EggTimer {
	public WebDriver driver;

	@Test
	public void f()  {
		
		driver.findElement(By.xpath("//input[@id='start_a_timer']")).clear();
				driver.findElement(By.xpath("//input[@id='start_a_timer']")).click();
		driver.findElement(By.xpath("//input[@id='start_a_timer']")).sendKeys("25 seconds");
		driver.findElement(By.xpath("//input[@id='timergo']")).click();
		String string = driver.getTitle();
		System.out.println("The current page title is " + string);

		WebElement timerStarted = driver.findElement(By.xpath("//h2[@id='progressText']"));
		System.out.println("The timer started at " + timerStarted.getText());
		

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Library\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://e.ggtimer.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterTest() {
	}

}
