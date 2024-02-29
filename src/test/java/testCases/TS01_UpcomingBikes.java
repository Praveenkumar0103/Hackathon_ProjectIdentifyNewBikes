package testCases;

import org.testng.annotations.Test;

import pages.upcomingBikes;
import testBase.Base;

public class TS01_UpcomingBikes extends Base{
	
	

		
		@Test(priority = 1)
		public void upComingBikes() throws Exception
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
		
		

}
