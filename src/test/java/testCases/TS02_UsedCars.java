package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.usedCars;
import testBase.Base;

public class TS02_UsedCars extends Base {

	
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
   
}
