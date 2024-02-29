package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.googleSignIn;

public class LoginGoogle {
	 WebDriver driver;
	 googleSignIn gs=new googleSignIn(BaseClass.getDriver());
	@Given("the user navigates to Login Account page")
	public void the_user_navigates_to_login_account_page()
	{
	    gs.clickSignIn();
	}

	@When("the user clicks the Google button")
	public void the_user_clicks_the_google_button() throws InterruptedException
	{
	    gs.googleLogIn(BaseClass.getDriver());
	}

	@Then("enters invalid email the user should get displayed with error message")
	public void enters_invalid_email_the_user_should_get_displayed_with_error_message() throws InterruptedException, IOException 
	{
	    gs.getErrorMessage(BaseClass.getDriver());
	    
	}
}
