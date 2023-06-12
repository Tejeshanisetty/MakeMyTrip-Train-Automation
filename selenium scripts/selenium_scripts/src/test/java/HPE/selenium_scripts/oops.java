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

class MakeMyTripPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MakeMyTripPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://www.makemytrip.com/");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='wewidgeticon we_close']"))).click();
        driver.switchTo().defaultContent();
    }

    public void clickTrainsTab() {
        driver.findElement(By.xpath("//span[@class='chNavText darkGreyText'][normalize-space()='Trains']")).click();
    }

    public void enterSource(String source) {
    	
        try {
        	WebElement source1=driver.findElement(By.xpath("//input[@id='fromCity']"));
        	source1.click();
            source1.sendKeys(source);
			Thread.sleep(2000);
			source1.sendKeys(Keys.ENTER);
	        List<WebElement> list=driver.findElements(By.xpath("//li[@role='option']//p"));
	        for(WebElement ele:list){
	            if(ele.getText().contains("Mumbai")){
	                ele.click();
	                break;
	            }
	        }

		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }

    public void enterDestination(String destination) {
    	
    try {
    	WebElement destination1=driver.findElement(By.xpath("//input[@id='toCity']"));
        destination1.click();
        destination1.sendKeys(destination);
        Thread.sleep(2000);
        destination1.sendKeys(Keys.ENTER);
        List<WebElement> destinationOptions=driver.findElements(By.xpath("//li[@role='option']//p"));
        for(WebElement ele:destinationOptions){
            if(ele.getText().contains("Chennai")){
                ele.click();
                break;
            }
        }
        
    } catch (InterruptedException e) {
  			
  			e.printStackTrace();
  		}
    }

    public void selectTravelDate(String date) {
        WebElement dateField = driver.findElement(By.xpath("//input[@id='travelDate']"));
        dateField.click();

        String flag = "False";

        while (flag.equals("False")) {
            if (driver.findElements(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'" + date + "')]")).size() > 0) {
                WebElement dateElement = driver.findElement(By.xpath("//div[@class='DayPicker-Day'][contains(@aria-label,'" + date + "')]"));
                dateElement.click();
                flag = "True";
                break;
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")))
                        .click();
            }
        }
    }

    public void searchTrains() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Search']")).click();
        Thread.sleep(5000);
    }
    
    public void chooseTrain() {
    	driver.findElement(By.xpath("//body/div[@id='root']/div/div/div[@class='flex justify-center']/div[@class='flex container justify-space-between']/div[@class='right-side-container']/div[@class='train-list']/div[1]/div[2]/div[1]/div[1]/div[2]")).click();
    }
    public void addTraveller(String name,String i) {
    	driver.findElement(By.xpath("(//label[normalize-space()=\"I don't want free cancellation\"])[1]")).click();
        driver.findElement(By.xpath("//span[@class='bold font14 capText']")).click();
    	WebElement Name=driver.findElement(By.xpath("//input[@id='name']"));
        Name.sendKeys(name);
        WebElement age1=driver.findElement(By.xpath("//input[@id='age']"));
        age1.sendKeys(i);
        WebElement genderDropdown =driver.findElement(By.xpath("(//div[contains(@class,'formField genderField makeFlex column appendRight20')]//div[contains(@role,'button')])"));
        genderDropdown.click();
        genderDropdown.sendKeys(Keys.ENTER);
        //Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[normalize-space()='Male'])")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Add'])")).click();
        
    }
    public void irctc() {
    	driver.findElement(By.xpath("//a[normalize-space()='CHANGE']")).click();  
        WebElement irctc=driver.findElement(By.xpath("//input[@id='IRCTCUserName']"));
        irctc.sendKeys("tejeshani123");
        driver.findElement(By.xpath("//span[@class='font12 latoBlack capText']")).click();
        //driver.close();
    }
    public void contactDetails() {
        WebElement email=driver.findElement(By.xpath("//input[@id='contactEmail']"));
        email.sendKeys("anisetty2002@gmail.com");
        WebElement number=driver.findElement(By.xpath("//input[@id='mobileNumber']"));
        number.sendKeys("6281306412");
    }
    public void address() {
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
    }
    public void payment() throws InterruptedException {
       driver.findElement(By.xpath("//a[@class='paymentBtn whiteText latoBlack font16 capText']")).click();
        
        
        WebElement upi=driver.findElement(By.xpath("//input[@id='inputVpa']"));
        upi.sendKeys("6281306412@ybl");
        driver.findElement(By.xpath("//button[normalize-space()='verify & pay']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[normalize-space()='CANCEL']")).click();
    }

}

public class oops {

    public static void main(String[] args) {
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            MakeMyTripPage makeMyTripPage = new MakeMyTripPage(driver, wait);
            makeMyTripPage.open();
            makeMyTripPage.clickTrainsTab();
            makeMyTripPage.enterSource("Mum");
            makeMyTripPage.enterDestination("Che");
            makeMyTripPage.selectTravelDate("Thu Jun 15 2023");
            makeMyTripPage.searchTrains();
            makeMyTripPage.chooseTrain();
            makeMyTripPage.addTraveller("Tejesh","21");
            makeMyTripPage.irctc();
            makeMyTripPage.contactDetails();
            makeMyTripPage.address();
            makeMyTripPage.payment();
            
            

            driver.close();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
