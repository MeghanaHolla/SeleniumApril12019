package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMessage {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
		
		driver.findElement(By.id("email")).sendKeys("batmannn233@hotmail.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("loginbutton")).click();
		
		
		String expectedResult = "The email address that you've entered doesn't match any account. Sign up for an account.";
		String actualResult = driver.findElement(By.cssSelector("#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer > div > div > div")).getText();
		
		if(expectedResult.equals(actualResult)) {
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
		}
		
		driver.close();
		
	}

}
