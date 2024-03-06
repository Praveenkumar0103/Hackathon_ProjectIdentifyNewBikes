package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.usedCars;
import testBase.Base;

public class TS02_UsedCars extends Base {

	usedCars usedCars;
	
	@Test(priority = 1,groups={"smoke","regression"})
	public void TC06_usedCars() throws InterruptedException, IOException
	{
		usedCars = new usedCars(driver);
		usedCars.usedCarsMenu(driver);
		captureScreen("UsedCarsMenu");
		logger.info("Hover done on used cars ");
	}	
	
	@Test(priority = 2,groups="regression")
	public void TC07_usedCarsChennai() throws InterruptedException, IOException 
	{	
		usedCars = new usedCars(driver);
		usedCars.selectChennaiUsedCars(driver);
		captureScreen("UsedCarsInChennai");
		logger.info("Used cars in chennai got clicked");
	}
	
	@Test(priority = 3,groups="regression")	
	public void TC08_popularModels() throws InterruptedException, IOException 
	{	
		usedCars = new usedCars(driver);	
		usedCars.modelList(driver);
		captureScreen("Popular Models");
		logger.info("Popular models of Used cars in chennai got executed and printed");
	}
   
}
