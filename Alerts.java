import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		WebElement resultElement = driver.findElement(By.id("result"));
		
		//js alerts
		WebElement alertElement = driver.findElement(By.xpath("//button[contains(text(),'Alert')]"));
		alertElement.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		WebElement confirmElement = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		confirmElement.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		System.out.println(resultElement.getText());
		confirmElement.click();
		driver.switchTo().alert().accept();
		System.out.println(resultElement.getText());
		
		String testString = "Test";
		WebElement promptElement = driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
		promptElement.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys(testString);
		driver.switchTo().alert().accept();
		Assert.assertEquals(resultElement.getText().split(":")[1].trim(),testString);
		
		driver.quit();
	
	}

}
