import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FormAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/login");

		driver.quit();
	}
	
	public void EnterUsername(WebDriver driver) {
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("username");
	}
	
	public void EnterPassword(WebDriver driver) {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password");
	}
	
	public void SubmitForm(WebDriver driver) {
		WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
		submitBtn.click();
	}
	
	public String GetErrorMsg(WebDriver driver) {
		WebElement errorMsgElement = driver.findElement(By.id("flash"));
		return errorMsgElement.getText();
		
	}
	
	// submit without the credentials
	//submit with wrong username
	//submit with wrong password
	//submit with correct credentials
	
	

}
