package testCases;

import org.testng.annotations.Test;

import pages.upcomingBikes;
import testBase.Base;

public class TS01_UpcomingBikes extends Base{
	
	    upcomingBikes up;

		
		@Test(priority = 1,groups={"smoke","regression"})
		public void TC01_newBikesHover() throws Exception
		{
			up = new upcomingBikes(driver);
			up.newBikesMenu(driver);
		    captureScreen("NewBikesMenu");
		    logger.info("Hover done on new bikes ");
		}    
		
		@Test(priority = 2,groups={"smoke","regression"})
		public void TC02_upComingBikesClick() throws Exception
		{
			up = new upcomingBikes(driver);
			up.selectUpcomingBike();
			captureScreen("UpcomingNewBikesMenu");
			logger.info("Navigated to upcoming bikes ");
		}
		
		@Test(priority = 3,groups="regression")
		public void TC03_selectManufacturer() throws Exception
		{	
			up = new upcomingBikes(driver);
			up.selectManufacturer();
			logger.info("Manufacturer Honda got selected ");
			captureScreen("ManufacturerDropdown");
        }
		
		@Test(priority = 4,groups="regression")	
		public void TC04_viewMoreBikes() throws Exception
		{
			up = new upcomingBikes(driver);
			up.viewMoreBikes(driver);
			logger.info("Clicked on View more options ");
			captureScreen("ViewMoreBikes");
			
			
			up.bikeModels();
			captureScreen("BikeModels");
			logger.info("Upcoming honda bikes less than four lakhs got executed and printed");
			
			
		}
		
		

}
