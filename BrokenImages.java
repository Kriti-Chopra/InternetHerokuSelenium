import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/broken_images");
		
		List<WebElement> imgElements = driver.findElements(By.xpath("//div[@class='example']//img"));
		
		for(WebElement imgElement:imgElements) {
			String srcString = "https://the-internet.herokuapp.com/"+ imgElement.getDomAttribute("src");
			System.out.println(srcString);
			HttpURLConnection connection = (HttpURLConnection) new URI(srcString).toURL().openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			
			int response = connection.getResponseCode();
			System.out.println(response);
			
		}
		
		driver.quit();
	}

}
