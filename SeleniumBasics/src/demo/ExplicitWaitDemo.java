package demo;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		
		driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.partialLinkText("that is hidden")).click();
		
		driver.findElement(By.cssSelector("#start > button")).click();
		
		String expectedResult = "Hello World!";
		
		//WebDriverWait wait = new WebDriverWait(driver,10);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(Duration.ofSeconds(30)).
				pollingEvery(Duration.ofSeconds(2)).
				ignoring(NoSuchElementException.class);
		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(("#finish > h4"))));
		
		String actualResult = driver.findElement(By.cssSelector("#finish > h4")).getText();
		System.out.println(actualResult);
		if(expectedResult.equals(actualResult)) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		
		//driver.close();
	}

}
