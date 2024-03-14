package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.Wait_;

import utilities.ExcelUtils;



public class googleSignIn extends basePage
{
	
	 WebDriver driver;
	//Constructor to initialize the web driver and page objects
	public googleSignIn(WebDriver driver) 
	{
		super(driver);
	}
	
	// page objects
	
	@FindBy(id="des_lIcon")
	WebElement signInButton;
	
	@FindBy(xpath = "//div[contains(@data-track-label,'Popup_Login/Register_with_Google')]")
	WebElement google;
	
	@FindBy(id = "identifierId")
	WebElement email;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement emailNextButton;
	
	@FindBy(xpath = "//div[contains(@class,'o6cuMc Jj6Lae')]")
	WebElement errorMessage;
	
	@FindBy(xpath = "//*[@id='report_submit_close_login']")
	WebElement closeSignin;
	


	
	public void clickSignIn() 
	{
		signInButton.click();	
	}
	
	// method to click on Sign In button
	public void googleLogIn(WebDriver driver) throws InterruptedException 
	{
		
		Wait_ wait = new Wait_();
		wait.waitExplicit(30,google,driver);
			google.click();
			
		
		
	}

	// method to enter invalid email ID
    public void getErrorMessage(WebDriver driver) throws InterruptedException, IOException 
      {
    	// Get all window handles
  		Set<String> Window = driver.getWindowHandles();
  		
  		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(2));
  	    List <String>  Window1 = new ArrayList<String> (Window); 
  	    driver.switchTo().window(Window1.get(1));
  	    
  	    for(int row=0;row<5;row++) 
  	    {
  	    	//Thread.sleep(3000);
  	    	String[] inputData = ExcelUtils.readData("Sheet1",row);
  	    	email.sendKeys(inputData[0]);
  	    	Thread.sleep(3000);
  	    	emailNextButton.click();
  	    	
  	       
  	    	if(errorMessage.getText().contains("Enter")|| errorMessage.getText().contains("Couldn’t "))
  	    	{ 
  	    		System.out.println("--------------- Error Message ------------------\n");
  	    		System.out.println("Error Message : "+ errorMessage.getText() );
  	    		email.clear();
  	    		System.out.println("-------------------------------------------------\n");
  	    		
  	    		
  	    	}
  	    	else 
  	    	{
  	    		System.out.println("Enter Password ");
  	    	}
  	      }
  	    
      }  
    
  	 // method to capture the error message
  	   public void navigation(WebDriver driver) throws InterruptedException 
  	   {
	
  		driver.close();
  		
        Set<String> Window = driver.getWindowHandles();
  		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(1));
  	    List <String>  Window1 = new ArrayList<String> (Window); 
		driver.switchTo().window(Window1.get(0));
		closeSignin.click();

	   }
  	   
}

