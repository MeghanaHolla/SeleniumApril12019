package demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		 Object[] getAllWindows = allWindows.toArray();
		 
		 String subWindowHandle = getAllWindows[1].toString();
		 
		 driver.switchTo().window(subWindowHandle);
		 
		 String actualResult = driver.findElement(By.cssSelector("body > div > h3")).getText();
		 
		 String expectedResult = "New Window";
		 if(expectedResult.equals(actualResult)){
			 System.out.println("Test Case Passed");
		 }
		 else {
			 System.out.println("Test Case Failed");
		 }
			
		 driver.close();
		 
		 driver.switchTo().window(mainWindow);
		 
		 driver.close();
	}

}
