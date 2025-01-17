import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Hovers {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url = "https://the-internet.herokuapp.com/hovers";
		By figureBy = By.xpath("//div[@class='figure']//img");
		By figureCaptionBy =By.xpath("//div[@class='figcaption']//h5");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Access the page
		driver.get(url);
	
		//hover over the images and get text
		List<WebElement> figuresList = driver.findElements(figureBy);
		List<WebElement> captionsList = driver.findElements(figureCaptionBy);
		for(int i=0;i<figuresList.size();++i) {
			Assert.assertFalse(captionsList.get(i).isDisplayed());
			Actions actions = new Actions(driver);
			actions.moveToElement(figuresList.get(i)).build().perform();
			Assert.assertTrue(captionsList.get(i).isDisplayed());
			System.out.println(captionsList.get(i).getText());
		}
		
		driver.quit();
		
	}

}
