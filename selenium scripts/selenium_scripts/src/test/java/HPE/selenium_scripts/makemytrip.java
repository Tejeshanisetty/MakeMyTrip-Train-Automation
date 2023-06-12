package HPE.selenium_scripts;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
//		driver.findElement(By.xpath("//li[contains(@data-cy,'account')]")).click();
//		WebElement phoneNumber = driver.findElement(By.xpath("//input[contains(@placeholder,'Enter email or mobile number')]"));
//		phoneNumber.sendKeys("6281306412");
//		driver.findElement(By.xpath("//button[contains(@data-cy,'continueBtn')]")).click();
//		driver.findElement(By.xpath("//div[contains(@class,'nsm7Bb-HzV7m-LgbsSe-Bz112c')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='wewidgeticon we_close']"))).click();
		driver.switchTo().defaultContent(); // Switch back from iframe to default content		
		driver.findElement(By.xpath("//span[@class='chNavText darkGreyText'][normalize-space()='Trains']")).click();
//		driver.findElement(By.xpath("//a[@class='wewidgeticon we_close']")).click();
//		driver.findElement(By.xpath("p[data-cy='defaultFromValue']")).click();
		
	    //driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();
	    //driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//p[2]")).click();
		
		WebElement source=driver.findElement(By.xpath("//input[@id='fromCity']"));
        source.click();
        source.sendKeys("MUM");
        Thread.sleep(2000);
        source.sendKeys(Keys.ENTER);
        List<WebElement> list=driver.findElements(By.xpath("//li[@role='option']//p"));
        for(WebElement ele:list){
            if(ele.getText().contains("Mumbai")){
                ele.click();
                break;
            }
        }
        
        WebElement destination=driver.findElement(By.xpath("//input[@id='toCity']"));
        destination.click();
        destination.sendKeys("CHE");
        Thread.sleep(2000);
        destination.sendKeys(Keys.ENTER);
        List<WebElement> destinationOptions=driver.findElements(By.xpath("//li[@role='option']//p"));
        for(WebElement ele:destinationOptions){
            if(ele.getText().contains("Chennai")){
                ele.click();
                break;
            }
        }
        
        
        
        
        driver.findElement(By.xpath("//input[@id='travelDate']")).click();
        Thread.sleep(2000);
        
        String flag = "False";
       

        while(flag=="False") {
         
         if(driver.findElements(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Thu Jun 15 2023')]")).size()>0) {
          
         driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'Thu Jun 15 2023')]")).click(); 
         flag="True";
         Thread.sleep(5000);
         }
         
         else {
          Thread.sleep(5000);
          driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
         }
         
        }
        
        
        
        driver.findElement(By.xpath("//a[normalize-space()='Search']")).click();
        Thread.sleep(5000);
       // driver.findElement(By.xpath("//input[@id='quickFilter-available']")).click();
        driver.findElement(By.xpath("//body/div[@id='root']/div/div/div[@class='flex justify-center']/div[@class='flex container justify-space-between']/div[@class='right-side-container']/div[@class='train-list']/div[1]/div[2]/div[1]/div[1]/div[2]")).click();
        
        driver.findElement(By.xpath("(//label[normalize-space()=\"I don't want free cancellation\"])[1]")).click();
        driver.findElement(By.xpath("//span[@class='bold font14 capText']")).click();
        
        
        
        WebElement Name=driver.findElement(By.xpath("//input[@id='name']"));
        Name.sendKeys("Tejesh");
        WebElement age=driver.findElement(By.xpath("//input[@id='age']"));
        age.sendKeys("21");
        WebElement genderDropdown =driver.findElement(By.xpath("(//div[contains(@class,'formField genderField makeFlex column appendRight20')]//div[contains(@role,'button')])"));
        genderDropdown.click();
        genderDropdown.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[normalize-space()='Male'])")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Add'])")).click();
        
        
        driver.findElement(By.xpath("//a[normalize-space()='CHANGE']")).click();  
        WebElement irctc=driver.findElement(By.xpath("//input[@id='IRCTCUserName']"));
        irctc.sendKeys("tejeshani123");
        driver.findElement(By.xpath("//span[@class='font12 latoBlack capText']")).click();
        
        
        
        WebElement email=driver.findElement(By.xpath("//input[@id='contactEmail']"));
        email.sendKeys("anisetty2002@gmail.com");
        WebElement number=driver.findElement(By.xpath("//input[@id='mobileNumber']"));
        number.sendKeys("6281306412");
        
        
        WebElement pincodeField = driver.findElement(By.xpath("//input[@id='pincode_gst_info']"));
        pincodeField.clear();
        pincodeField.sendKeys("524101");
        
        
        WebElement stateDropdown = driver.findElement(By.xpath("//input[@id='dt_state_gst_info']"));
        stateDropdown.click();
        WebElement desiredState = driver.findElement(By.xpath("//ul[contains(@class,'dropdownListWpr')]//li[text()='Andhra Pradesh']"));
        desiredState.click();
        
        
        WebElement address=driver.findElement(By.xpath("(//input[@id='address_gst_info'])"));
        address.sendKeys("Gudur");
        
        driver.findElement(By.xpath("//span[@class='checkboxWpr']")).click();
        
        driver.findElement(By.xpath("//a[@class='paymentBtn whiteText latoBlack font16 capText']")).click();
        
        
        WebElement upi=driver.findElement(By.xpath("//input[@id='inputVpa']"));
        upi.sendKeys("6281306412@ybl");
        driver.findElement(By.xpath("//button[normalize-space()='verify & pay']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[normalize-space()='CANCEL']")).click();
        
        
        
//        WebElement stateDropdown = driver.findElement(By.xpath("//input[@id='dt_state_gst_info']"));
//        stateDropdown.click();
//        stateDropdown.sendKeys("AND");
//        Thread.sleep(2000);
//        List<WebElement> stateOptions = driver.findElements(By.xpath("//ul[contains(@class,'dropdownListWpr')]"));
//        for (WebElement ele : stateOptions) {
//            if (ele.getText().contains("Andhra Pradesh")) {
//                ele.click();
//                break;
//            }
//        }
        
        
//        WebElement pincode=
//          driver.findElement(By.xpath("//input[@id='pincode_gst_info']")).clear();
//        pincode.clear();
//        pincode.sendKeys("524101");
//        WebElement state=driver.findElement(By.xpath("//input[@id='dt_state_gst_info']"));
//        state.click();
//        state.sendKeys("AND");
//        Thread.sleep(2000);
//        state.sendKeys(Keys.ENTER);
//        List<WebElement> stateOptions=driver.findElements(By.xpath("//ul[contains(@class,'dropdownListWpr')]"));
//        for(WebElement ele:stateOptions){
//            if(ele.getText().contains("Andhra Pradesh")){
//                ele.click();
//                break;
//            }
//        }
        //driver.findElement(By.xpath("//input[@id='dt_state_gst_info']")).click();		
      
        
        
        
     // Create object of the Select class
        //Select se = new Select(driver.findElement(By.xpath("//span[normalize-space()='Select']")));
        			
        // Select the option by index
        //se.selectByIndex(0);
        
//		f.findElement(By.xpath("//div[contains(@class, 'hsw_autocomplePopup')]//p[contains(.,'Chennai') and contains(@class,'font16')]")).click();
//		driver.findElement(By.xpath("driver.findElement(By.xpath(\"//input[@data-cy='fromCity']\")).click()]")).click();
		
		
		
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'From')]"))).click();
//		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Delhi, India')]"))).click();
//
//		wait1.until(ExpectedConditions.elementToBeClickabmle(By.xpath("//span[contains(text(),'To')]"))).click();
//		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Mumbai, India')]"))).click();
		
		
		driver.close();
	    driver.quit();
		}
		catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		


	}

}
