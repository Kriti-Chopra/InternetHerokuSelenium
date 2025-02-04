import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/download");
		
		File oldFile = GetLatestDownloadedFile();
		
		WebElement fileLink = driver.findElement(By.linkText("Mega.png"));
		fileLink.click();
		
		File newFile = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(webDriver -> {
		    File latestFile = GetLatestDownloadedFile();

		    if (latestFile != null && (oldFile == null || !latestFile.getName().equals(oldFile.getName()))) {
		        // Ensure the file is completely downloaded (no .crdownload or .part extension)
		        return !latestFile.getName().endsWith(".crdownload") && !latestFile.getName().endsWith(".part");
		    }
		    return false;
		});

		newFile = GetLatestDownloadedFile();
		System.out.println(newFile.getName());
		
		driver.quit();
	}
	
	public static File GetLatestDownloadedFile() {
		File fileLocation = new File("/Users/name/Downloads/");
		File[] listArray = fileLocation.listFiles();
		File latestFile = Arrays.stream(listArray).filter(file-> file.isFile())
				.max(Comparator.comparingLong(file -> file.lastModified())).orElse(null);
		return latestFile;
	}

}
