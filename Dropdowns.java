import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://the-internet.herokuapp.com/dropdown";
		By ddnBy = By.id("dropdown");
		
		//navigate to the page
		driver.get(url);
		
		//access dropdown and select second value and validate
		WebElement ddnElement = driver.findElement(ddnBy);
		Select dropdown = new Select(ddnElement);
		dropdown.selectByValue("2");
		
		List<WebElement> selectedOptionsList = dropdown.getAllSelectedOptions();
		Assert.assertTrue(selectedOptionsList.size()==1);
		for(WebElement option: selectedOptionsList) {
			System.out.println(option.getText());
		}
		
		driver.close();
		driver.quit();

	}

}
