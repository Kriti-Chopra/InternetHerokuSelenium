
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddRemoveElements {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String siteUrl = "https://the-internet.herokuapp.com/";
		By addRemoveTestingLnkBy = By.linkText("Add/Remove Elements");
		String heading = "Add/Remove Elements";
		By addBtnbBy = By.cssSelector("div.example button");
		By removeBtnBy = By.cssSelector("button.added-manually");
		
		//navigate to site
		driver.get(siteUrl);
		
		//click on Add remove element and validate page access
		WebElement addRemoveTestLnk = driver.findElement(addRemoveTestingLnkBy);
		addRemoveTestLnk.click();
		WebElement pageHeading = driver.findElement(By.tagName("h3"));
		Assert.assertEquals(pageHeading.getText(),heading);
		
		//click add > validate button addition
		WebElement addBtn = driver.findElement(addBtnbBy);
		addBtn.click();
		
		//click remove > validate button removal
		WebElement removeBtn = driver.findElement(removeBtnBy);
		Assert.assertTrue(removeBtn.isDisplayed());
		removeBtn.click();
		Assert.assertEquals(driver.findElements(removeBtnBy).size(),0);
		
		driver.close();
		driver.quit();
		
	}
}
