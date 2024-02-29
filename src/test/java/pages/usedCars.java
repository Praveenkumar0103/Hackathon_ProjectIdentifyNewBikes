package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import testBase.Wait_;
import utilities.ExcelUtils;



public class usedCars  extends basePage
{
	WebDriver driver;
	
	public usedCars(WebDriver driver) 
	{
		super(driver);
	}
	
	// WebElements for used cars page
	
	@FindBy(xpath = "//a[normalize-space()='Used Cars']")
	WebElement usedCarsMenu;
	
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement chennaiUsedCars;
	
	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
	List<WebElement> modelName;
	
	JavascriptExecutor js;
	
	// Mouse hover on 'Used cars' menu from the main menu bar
	
	public void usedCarsMenu(WebDriver driver) throws InterruptedException {
	
		Thread.sleep(5000);
		js = (JavascriptExecutor) driver;
	    js.executeScript("scroll(0, -1400)");
	    Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(usedCarsMenu).perform();
		
	}
	
	// Click on 'Used cars in Chennai' link
	
	public void selectChennaiUsedCars(WebDriver driver) throws InterruptedException {
		
		Thread.sleep(5000);
		chennaiUsedCars.click();

	}
	
	// Get list of all popular models of used cars in Chennai and write to excel file
	
	public void modelList(WebDriver driver) throws InterruptedException, IOException {
		 
		// Scroll down to make all elements visible
		Thread.sleep(5000);
		js = (JavascriptExecutor) driver;
	    js.executeScript("scroll(0, 500)");
	    
	    Wait_ wait = new Wait_();
		wait.waitListExplicit(30, modelName, driver);
	    
	    // Display the list of popular models on the console
	   
	    System.out.println("\n" + "Following is the list of Popular models:");
	    List<String> modelNames = new ArrayList<String>();
	    
	    for(WebElement e : modelName) 
	    {
	    	System.out.println( e.getText());
	    	modelNames.add(e.getText());	
	    }
		ExcelUtils eu=new ExcelUtils();
		eu.writeData("car models", modelNames, 0, 0);
	}
	
}
