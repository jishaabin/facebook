
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//##################################################################################################################################################################
/*Assigmnent 1 Wallet Hub
   Created By : Jisha Anie George
         Date : 24-07-2019
    Testcases  :  
				1.Login to Facebook.Username and Password should be on a variable we can change.
                2.Post a status message "Hello World
         */
//##################################################################################################################################################################


public class facebook {

	WebDriver driver=null;
	
	//Initializing driver 
	@BeforeTest
	public void Setup() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	//Actual test to Login and share the status 
	@Test
	public void Login() {
		String uname="******@gmail.com";
		String pwd="*******";
		
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("pass")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("After login title is = " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Facebook"));
		
	}
	
	
	//Posting Status Message
	@Test
	public void PostStatus() {
		
		driver.findElement(By.xpath("//span[text()='Create Post']")).click();
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Hello World");
		driver.findElement(By.xpath("//button[@data-testid='react-composer-post-button']")).click();
		
	}
	
	//Closing the browser
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
		
	}


