
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HorizontalScroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://the-internet.herokuapp.com/horizontal_slider";
		int expectedValue= 3;
		By sliderBy = By.cssSelector("input[type='range']");
		By actualValueBy = By.id("range");
		
		//Access the page
		driver.get(url);
		WebElement slider = driver.findElement(sliderBy);
		WebElement actualValue = driver.findElement(actualValueBy);
		
		//Scroll the slider with arrow keys
		int numOfTaps = 2*expectedValue;
		Actions action = new Actions(driver);
		for(int i=0;i<numOfTaps;++i) {
			action.sendKeys(slider, Keys.ARROW_RIGHT).perform();
		}
		
		System.out.println(actualValue.getText());
		Assert.assertEquals(expectedValue,Integer.parseInt(actualValue.getText()));
		driver.quit();

	}

}
