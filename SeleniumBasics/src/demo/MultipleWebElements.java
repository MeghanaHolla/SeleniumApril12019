package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWebElements {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> getLinks = driver.findElements(By.tagName("a"));
		
		Object[] getAllLinks = getLinks.toArray();
		
		for(int i = 0;i<getAllLinks.length;i++) {
			System.out.println(((WebElement) getAllLinks[i]).getText());
		}
		
	}

}
