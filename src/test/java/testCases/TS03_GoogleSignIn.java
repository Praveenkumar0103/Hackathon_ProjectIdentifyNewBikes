package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.googleSignIn;
import testBase.Base;

public class TS03_GoogleSignIn extends Base {

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
