package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		String expectedResult = "Facebook – log in or sign up";
		
		String actualResult = driver.getTitle();
		
		if(expectedResult.equals(actualResult)) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		
		driver.close();

	}

}
