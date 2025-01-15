
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class KeyPresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://the-internet.herokuapp.com/key_presses";
		By inputBoxBy = By.id("target");
		By resultBy= By.cssSelector("p#result");
		String[] expectedKeyStrings= new String[]{"Escape","space","tab","control"};
		Keys[] providedKeysList= new Keys[]{Keys.ESCAPE,Keys.SPACE,Keys.TAB,Keys.CONTROL};
		
		//Access page
		driver.get(url);
		
		//enter keys and validate
		for(int i=0;i<expectedKeyStrings.length;++i) {
			WebElement inputBox = driver.findElement(inputBoxBy);
			inputBox.sendKeys(providedKeysList[i]);
			WebElement result = driver.findElement(resultBy);
			String actualResult = result.getText().split(":")[1].trim();
			System.out.println(actualResult);
			Assert.assertEquals(actualResult.toLowerCase(), expectedKeyStrings[i].toLowerCase() );
			
		}
		
		driver.close();
		driver.quit();
	
	}

}
