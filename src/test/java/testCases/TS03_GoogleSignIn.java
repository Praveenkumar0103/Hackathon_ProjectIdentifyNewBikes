package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.googleSignIn;
import testBase.Base;

public class TS03_GoogleSignIn extends Base {
	
	googleSignIn signin;
	
	@Test(priority =0,groups={"smoke","regression"})
	public void TC07_clickSignIn() throws InterruptedException, IOException
	{
		signin = new googleSignIn(driver);
		signin.clickSignIn();
		logger.info("Clicked on Login button");
	}	
	
	@Test(priority =1,groups={"smoke","regression"})
	public void TC08_googleSignIn() throws InterruptedException, IOException
	{
		signin = new googleSignIn(driver);
		signin.googleLogIn(driver);
		logger.info("Clicked on login with google");
		
	}
	
	@Test(priority =2,groups="regression")
	public void TC09_captureErrorMessage() throws InterruptedException, IOException
	{
		signin = new googleSignIn(driver);
		signin.getErrorMessage(driver);
		captureScreen("ErrorMessage");
		logger.info("Captured error message on using invalid login credentials ");
		signin.navigation(driver);
		logger.info("Login page execution got failed and captured error message");
	}
	
}
