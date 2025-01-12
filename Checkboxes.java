

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String checkboxUrl = "https://the-internet.herokuapp.com/checkboxes";
		By checkboxesListBy = By.xpath("//input[@type='checkbox']");
		
		//goto the link
		driver.get(checkboxUrl);
		
		//get count of checkboxes
		List<WebElement> checkboxList = driver.findElements(checkboxesListBy);
		System.out.println(checkboxList.size());
		
		//check first checkbox and uncheck second and validate
		checkboxList.get(0).click();
		checkboxList.get(1).click();
		Assert.assertTrue(checkboxList.get(0).isSelected());
		Assert.assertFalse(checkboxList.get(1).isSelected());
		
		driver.close();
		driver.quit();

	}

}
