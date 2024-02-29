package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.usedCars;

public class UsedCarsChennai 
{
	WebDriver driver =BaseClass.getDriver();
	usedCars uc=new usedCars(driver);
	@Given("the user navigates to used cars menu")
	public void the_user_navigates_to_used_cars_menu() throws InterruptedException
	{
		
	    uc.usedCarsMenu(driver);
	}

	@When("the user clicks on chennai in used cars")
	public void the_user_clicks_on_chennai_in_used_cars() throws InterruptedException
	{
		
	    uc.selectChennaiUsedCars(driver);
	}

	@Then("the user need to scroll down to get displayed with popular models")
	public void the_user_need_to_scroll_down_to_get_displayed_with_popular_models() throws InterruptedException, IOException 
	{
		
	    uc.modelList(driver);
	}

}
