import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		
		WebElement hiddenElementLink = driver.findElement(By.xpath("//a[contains(@href,'dynamic_loading/1')]"));
		hiddenElementLink.click();
		
		WebElement startBtn = driver.findElement(By.xpath("//div[@id='start']/button"));
		startBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
		WebElement finishElement = driver.findElement(By.id("finish"));
		System.out.println(finishElement.getText());
		
		driver.quit();
		
	}

}
