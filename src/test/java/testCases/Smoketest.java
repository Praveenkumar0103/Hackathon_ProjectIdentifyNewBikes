package testCases;
import java.io.IOException;

import org.testng.annotations.Test;



import pages.upcomingBikes;
import pages.usedCars;
import pages.googleSignIn;
import testBase.Base;

public class Smoketest extends Base
{
	
	@Test(priority = 1)
	public void upComingBikes() throws Exception
	{
		upcomingBikes up = new upcomingBikes(driver);
		up.newBikesMenu(driver);
		captureScreen("UpcomingNewBikesMenu");
		up.selectUpcomingBike();
		
		
		logger.info("Upcoming bikes executed successfully");
	}
	
	
	
	@Test(priority = 2)
	public void usedCars() throws InterruptedException, IOException
	{
		usedCars usedCars = new usedCars(driver);
		usedCars.usedCarsMenu(driver);
		usedCars.selectChennaiUsedCars(driver);
		captureScreen("UsedCarsMenu");
		
		
		logger.info("Used cars executed successfully");
	}
	@Test(priority =3)
	public void testGoogleSignIn() throws InterruptedException, IOException
	{
		googleSignIn signin = new googleSignIn(driver);
		signin.clickSignIn();
		signin.googleLogIn(driver);
		
		signin.navigation(driver);
		logger.info("Login page execution completed Successfully");
		
	}
   
}	
	

