package blazedemohomepage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class HomePage {
	public WebDriver driver;

		@Test(priority = 1)
	public void findFligts() {
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")).click();
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Test User");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Test Address");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Test City");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Test State");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("12345");
		new Select(driver.findElement(By.xpath("//select[@id='cardType']"))).selectByVisibleText("American Express");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("4581235645879632");
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("08");
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2021");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("User Name");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		driver.navigate().to("https://blazedemo.com/confirmation.php");

		List<WebElement> confirMsgElement = driver
				.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]"));
		System.out.println(confirMsgElement.get(0).getText());

	}

	@Test(priority = 2)
	public void destLink() throws InterruptedException {
		beforeTest();
		driver.findElement(By.linkText("destination of the week! The Beach!")).click();
		

	}

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Library\\Chrome_Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/index.php");
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

}
