import java.security.PublicKey;
import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormAuthentication {
	
	static WebDriver driver = new ChromeDriver();
	String usernameInvalidMsg = "Your username is invalid!"; 
	String passwordInvalidMsg = "Your password is invalid!";
	String validUsername = "tomsmith";
	String validPassword = "SuperSecretPassword!";
	String validLoginMsg = "You logged into a secure area!";
	String loggedOutMsg = "You logged out of the secure area!";

	public void EnterUsername(String username) {
		WebElement usernameTextBox = driver.findElement(By.id("username"));
		usernameTextBox.sendKeys(username);
	}
	
	public void EnterPassword(String password) {
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.sendKeys(password);
	}
	
	public void SubmitForm() {
		WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
		submitBtn.click();
	}
	
	public String GetErrorMsg() {
		WebElement errorMsgElement = driver.findElement(By.id("flash"));
		return errorMsgElement.getText().trim().split("!")[0]+"!";
	}
	
	public void Logout() {
		WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(@class,'radius')]"));
		logoutBtn.click();
	}
	
	@BeforeClass
	public void Initialize() {
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
	}
	
	@AfterClass
	public void CloseDriver() {
		driver.quit();
	}
	
	// submit without the credentials
	@Test(priority = 1)
	public void VerifySubmitWithoutCredentials() {
		SubmitForm();
		Assert.assertEquals(usernameInvalidMsg,GetErrorMsg());
	}
	
	//submit with wrong username
	@Test(priority = 2)
	public void VerifySubmitInvalidUsername() {
		EnterUsername("Admin");
		SubmitForm();
		Assert.assertEquals(usernameInvalidMsg,GetErrorMsg());
	}
	
	//submit with wrong password
	@Test(priority = 3)
	public void VerifySubmitInvalidPassword() {
		EnterUsername(validUsername);
		EnterPassword("Admin");
		SubmitForm();
		Assert.assertEquals(passwordInvalidMsg,GetErrorMsg());
	}
	
	//submit with correct credentials
	@Test(priority = 4)
	public void VerifySubmitValidCredentials() {
		EnterUsername(validUsername);
		EnterPassword(validPassword);
		SubmitForm();
		Assert.assertEquals(validLoginMsg,GetErrorMsg());
	}
	
	//Logout
	@Test(priority = 5)
	public void VerifyLogout() {
		Logout();
		Assert.assertEquals(loggedOutMsg,GetErrorMsg());
	}
	

}
