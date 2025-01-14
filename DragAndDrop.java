import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAndDrop {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = "https://the-internet.herokuapp.com/drag_and_drop";
		By columnHeaderBy = By.xpath("//div[@id='columns']//header");
		By boxABy = By.id("column-a");
		By boxBBy = By.id("column-b");
		String[] expectedList = new String[]{"A","B"};
		
		//access page
		driver.get(url);
		
		List<WebElement> columnHeaderList = driver.findElements(columnHeaderBy);
		System.out.println(columnHeaderList.size());
		for(int i=0;i<columnHeaderList.size();++i) {
			Assert.assertEquals(columnHeaderList.get(i).getText(),expectedList[i]);
		}
		
		//drag A and drop on B and validate
		Actions action = new Actions(driver);
		WebElement boxA = driver.findElement(boxABy);
		WebElement boxB = driver.findElement(boxBBy);
		action.dragAndDrop(boxA, boxB).build().perform();
		
		columnHeaderList = driver.findElements(columnHeaderBy);
		System.out.println(columnHeaderList.size());
		for(int i=0;i<columnHeaderList.size();++i) {
			Assert.assertEquals(columnHeaderList.get(i).getText(),expectedList[expectedList.length-1-i]);
		}

		driver.close();
		driver.quit();
		
	}

}
