package testCases;


import java.io.IOException;

import org.testng.annotations.Test;



import pages.upcomingBikes;
import pages.usedCars;
import pages.googleSignIn;
import testBase.Base;

public class Regressiontest extends Base
{

	
	
	@Test(priority = 1)
	public void upcomingBikes() throws Exception
	{
		upcomingBikes up = new upcomingBikes(driver);
		
		up.newBikesMenu(driver);
	    captureScreen("NewBikesMenu");
	    logger.info("Hover done on new bikes ");
	    
		up.selectUpcomingBike();
		captureScreen("UpcomingNewBikesMenu");
		logger.info("Navigated to upcoming bikes ");
		
		captureScreen("ManufacturerDropdown");
		up.selectManufacturer();
		logger.info("Manufacturer Honda got selected ");
		
		captureScreen("ViewMoreBikes");
		up.viewMoreBikes(driver);
		logger.info("Clicked on View more options ");
		
		captureScreen("BikeModels");
		up.bikeModels();
		logger.info("Upcoming honda bikes less than four lakhs got executed and printed");
		
		
	}
	
	@Test(priority = 2)
	public void usedCars() throws InterruptedException, IOException {
		usedCars usedCars = new usedCars(driver);
		
		usedCars.usedCarsMenu(driver);
		captureScreen("UsedCarsMenu");
		logger.info("Hover done on used cars ");
		
		usedCars.selectChennaiUsedCars(driver);
		captureScreen("UsedCarsInChennai");
		logger.info("Used cars in chennai got clicked");
		
		usedCars.modelList(driver);
		logger.info("Popular models of Used cars in chennai got executed and printed");
	}
	
	
	
	@Test(priority =0)
	public void testGoogleSignIn() throws InterruptedException, IOException
	{
		googleSignIn signin = new googleSignIn(driver);
		
		signin.clickSignIn();
		logger.info("Clicked on Login button");
		signin.googleLogIn(driver);
		logger.info("Clicked on login with google");
		signin.getErrorMessage(driver);
		captureScreen("ErrorMessage");
		logger.info("Captured error message on using invalid login credentials ");
		signin.navigation(driver);
		logger.info("Login page execution got failed and captured error message");
	}
   
	
	
	
	
	
		
		
}