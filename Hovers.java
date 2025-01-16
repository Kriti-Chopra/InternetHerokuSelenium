import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Hovers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://the-internet.herokuapp.com/hovers
		//div[@class='figure']//img
		//div[@class='figcaption']//h5
		
		String url = "https://the-internet.herokuapp.com/hovers";
		By figureBy = By.cssSelector("div.figure img");
		By figureCaptionBy =By.cssSelector("div.figcaption h5");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Access the page
		driver.get(url);
		
		//hover over the images and get text
		List<WebElement> figuresList = driver.findElements(figureBy);
		for(WebElement figure:figuresList) {
			Actions actions = new Actions(driver);
			actions.moveToElement(figure).build().perform();
			
			
		}
		
	}

}
