package HPE.selenium_scripts;
import java.time.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class bookmyshow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.get("https://in.bookmyshow.com/");
		driver.findElement(By.xpath("//span[contains(text(),'Bengaluru')]")).click();
		driver.findElement(By.xpath("//div[text()=\"Sign in\"]")).click();
		WebElement phoneNumber = driver.findElement(By.xpath("//input"));
		phoneNumber.sendKeys("6281306412");
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

	}

}
