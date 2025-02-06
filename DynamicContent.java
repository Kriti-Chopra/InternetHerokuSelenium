import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicContent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_content");
		
		List<WebElement> contentList = driver.findElements(By.xpath("//div[@class='row']/div[@class='large-10 columns']"));
		
		//get dynamic load data
		List<String> dynamicList = new ArrayList<String>();
		for(int i=0;i<contentList.size();++i) {
			dynamicList.add(i,contentList.get(i).getText());
		}
		
		driver.navigate().refresh();
		contentList = driver.findElements(By.xpath("//div[@class='row']/div[@class='large-10 columns']"));
		for(int i=0;i<contentList.size();++i) {
			System.out.println("here");
			Assert.assertTrue(dynamicList.get(i)!=contentList.get(i).getText());
		}
		
		
		
		
		driver.quit();
		
	}

}
