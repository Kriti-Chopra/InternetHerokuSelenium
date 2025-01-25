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
import org.testng.Assert;

public class StatusCodes {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String urlString = "https://the-internet.herokuapp.com/status_codes";
		driver.get(urlString);
		
		List<WebElement> listOfLinks = driver.findElements(By.cssSelector("li a"));
		for(WebElement link: listOfLinks) {
			int expected= Integer.parseInt(link.getText());
			HttpURLConnection connection = 
					(HttpURLConnection) new URI(driver.getCurrentUrl()+"/"+link.getText()).toURL().openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int actual = connection.getResponseCode();
			connection.disconnect();
			Assert.assertEquals(expected,actual);
		}
		
		driver.quit();
	}

}
