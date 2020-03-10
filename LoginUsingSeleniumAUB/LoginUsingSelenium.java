import org.junit.Test;
import org.openqa.selenium.By;   
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver; 
import static org.junit.Assert.assertEquals;


public class LoginUsingSelenium 
{     
	@Test 
	public void login() 
	{
	    //System Property for Chrome Driver   
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aya\\Desktop\\chromedriver.exe");  
	      
	    // Instantiate a ChromeDriver class.     
	    WebDriver driver=new ChromeDriver();  
	
	    driver.manage().window().maximize();
	
	    String actualUrl = "https://www-banner.aub.edu.lb/pls/weba/twbkwbis.P_WWWLogin";
	
	    driver.get(actualUrl);    

	    //inputs username
	    driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[1]/td[2]/input")).click();         
	    driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[1]/td[2]/input")).sendKeys("username");      
	
	    //inputs password
	    driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input")).click(); 
	    driver.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("password"); 
	    
	    //opens Personal Information
	    driver.findElement(By.xpath("/html/body/div[3]/form/p/input[1]")).click();
	    
	    //opens View E-mail Address(es)
	    driver.findElement(By.xpath("/html/body/div[3]/table[2]/tbody/tr[4]/td[2]/a")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/table[1]/tbody/tr[5]/td[2]/a")).click();
	    
	    System.out.println("Test Case #1");
	    System.out.println("================");
	    
	    //copies and prints the email
	    String email = driver.findElement(By.className("dddefault")).getText(); 
	    System.out.println(email); 
	    
	    //opens Student Services
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/map/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();
	    //opens Check Your Registration Status
	    driver.findElement(By.xpath("/html/body/div[3]/table[1]/tbody/tr[1]/td[2]/a")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/table[1]/tbody/tr[2]/td[2]/a")).click();
	    
	    //copies and prints the AUBID
	    String AUBID = driver.findElement(By.className("staticheaders")).getText(); 
	    System.out.println(AUBID); 
	    
	    driver.findElement(By.xpath("/html/body/div[3]/table[1]/tbody/tr[2]/td[2]/a")).click();

	    String final_web = "https://www-banner.aub.edu.lb/pls/weba/bwskrsta.P_RegsStatusDisp";
	    String expectedUrl= driver.getCurrentUrl(); 
		 
	    assertEquals(expectedUrl,final_web);
	}
}
