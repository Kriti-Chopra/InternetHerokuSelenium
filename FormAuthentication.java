import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/login");
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
		
		username.sendKeys("username");
		password.sendKeys("password");
		submitBtn.click();
		
		WebElement errorMsgElement = driver.findElement(By.id("flash"));
		System.out.println(errorMsgElement.getText());

		// verify wrong validation 
		// Verify validation msgs
		
		driver.quit();
	}

}
