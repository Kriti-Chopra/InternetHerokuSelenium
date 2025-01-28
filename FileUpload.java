import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/upload");
		
		WebElement uploadBtn = driver.findElement(By.id("file-upload"));
		uploadBtn.sendKeys("/Users/kriti/Downloads/dummy.pdf");

		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
		fileSubmit.click();
		
		WebElement filenameElement = driver.findElement(By.id("uploaded-files"));
		Assert.assertEquals(filenameElement.getText().trim(), "dummy.pdf");
		
		driver.quit();
	}

}
