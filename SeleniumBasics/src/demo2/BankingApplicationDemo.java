package demo2;
/*Test Information
 * Description
 * Author Name
 * Date
 * Review Date
 * 
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BankingApplicationDemo {
	
	WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/index.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	
	public void login() {
		driver.findElement(By.id("transfer_funds_link")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
	}
	@Test
	//Modifyig the code after defect click
	public void validateFundTransfer()  {
		
		WebElement fromAccount = driver.findElement(By.id("tf_fromAccountId"));
		Select selectFromAcc = new Select(fromAccount);
		selectFromAcc.selectByIndex(2);
		
		WebElement toAccount = driver.findElement(By.id("tf_toAccountId"));
		Select selectToAcc = new Select(toAccount);
		selectToAcc.selectByIndex(3);
		
		String expectedResult = "200";
		//Validating 
		driver.findElement(By.id("tf_amount")).sendKeys(expectedResult);
		driver.findElement(By.id("tf_description")).sendKeys("transfer account from savings to Loan Account");
		driver.findElement(By.id("btn_submit")).click();
		
		
		String confirmationAmount = driver.findElement(By.id("tf_amount")).getAttribute("value");
		System.out.println("*"+confirmationAmount);
		Assert.assertEquals(confirmationAmount, expectedResult);
		
		if(expectedResult.equals(confirmationAmount)) {
			driver.findElement(By.id("btn_submit")).click();
			String expectedMsg = "You successfully submitted your transaction.";
			String actualMsg = driver.findElement(By.cssSelector("#transfer_funds_content > div > div > div.alert.alert-success")).getText();
			Assert.assertEquals(actualMsg, expectedMsg);
		}
		
		else {
			Assert.fail("Confirmation Amount is incorrect. Not matching with the amount entered during fund transfer");
		}
	}
	
	@AfterTest
	public void closeApplication() {
		driver.findElement(By.cssSelector("#settingsBox > ul > li:nth-child(3) > a")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}
}
