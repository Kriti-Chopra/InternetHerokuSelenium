import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://the-internet.herokuapp.com/windows";
		driver.get(url);
		
		//open in new tab and access
		WebElement newTabButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
		newTabButton.click();
		
		Set<String> windows= driver.getWindowHandles();
		for(String window:windows) {
			driver.switchTo().window(window);
			System.out.println(driver.getCurrentUrl());
		}
		
		driver.quit();
	}

}
