package stepDefinition;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.upcomingBikes;

public class UpcomingHondaBikes {
	WebDriver driver;
	upcomingBikes ub=new upcomingBikes(BaseClass.getDriver());
	@Given("the user navigates to new bikes menu")
	public void the_user_navigates_to_new_bikes_menu() throws Exception 
	{
		Thread.sleep(5000);
		ub.newBikesMenu(BaseClass.getDriver());
	    
	}

	@Given("selects the upcoming bikes")
	public void selects_the_upcoming_bikes() throws Exception 
	{
		Thread.sleep(5000);
		ub.selectUpcomingBike();
	}

	@When("the user selects the manufacturer as Honda")
	public void the_user_selects_the_manufacturer_as_honda() throws Exception 
	{
		Thread.sleep(5000);
	    ub.selectManufacturer();
	}

	@When("clicks on view more bikes")
	public void clicks_on_view_more_bikes() throws Exception 
	{
		
	    ub.viewMoreBikes(BaseClass.getDriver());
	}

	@Then("the honda bikes less than four lakhs gets displayed")
	public void the_honda_bikes_less_than_four_lakhs_gets_displayed() throws Exception 
	{
		
	    ub.bikeModels();
	}


}
