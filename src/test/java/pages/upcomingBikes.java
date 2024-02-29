package pages;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtils;

public class upcomingBikes extends basePage {

	WebDriver driver;
	
	public upcomingBikes(WebDriver driver) 
	{
		super(driver);
	}
	
	
	// WebElements for Upcoming Bikes Page
	
		@FindBy(xpath= "//a[contains(text(),'New Bikes')]")
		WebElement newBikesMenu;
		
		@FindBy(xpath = "//span[contains(text(),'Upcoming Bikes')]")
		WebElement upcomingBikes;
		
		@FindBy(id = "makeId")
		WebElement manufacturer;
		
		@FindBy(xpath = "//span[contains(text(),'View More Bikes')]")
		WebElement viewMore;
		
		@FindBy(xpath = "//*[@id='carModels']/ul")
		WebElement hondaBikeModels;
	
		
		double limit=400000.0;
		String info;
		// Hover over 'New Bikes' menu to view 'Upcoming Bikes'
		
		public void newBikesMenu(WebDriver driver) throws Exception 
		{
			
			Actions action = new Actions(driver);
			action.moveToElement(newBikesMenu).perform(); // Move mouse to 'New Bikes' menu
		}

		// Select 'Upcoming Bikes'
		public void selectUpcomingBike() throws Exception 
		{

			upcomingBikes.click(); // Click 'Upcoming Bikes'
		
		}
		
		// Select 'Honda' as manufacturer
		public void selectManufacturer() throws Exception 
		{
			
			
			Select select = new Select(manufacturer);
			select.selectByVisibleText("Honda");  // Select 'Honda'
			
		}
		// Click 'View More Bikes'
			
		public void viewMoreBikes(WebDriver driver) throws Exception 
		{	
			
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("window.scrollBy(0,1400)");
			executor.executeScript("arguments[0].click();", viewMore);
		
		
		}

		
		// Get bike models, prices, and expected launch date
		public void bikeModels() throws Exception {
			
			// Get text of all bike models available on the page
			String bikeModels = hondaBikeModels.getText();
			
			// Split the text by new line character and store it in an ArrayList
			ArrayList<String> bikeModelsElements = new ArrayList<String>();
			Collections.addAll(bikeModelsElements, bikeModels.split("\n"));
	        
			// Initialize ArrayLists to store names, launch dates and prices of bikes
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> dateList = new ArrayList<String>();
			ArrayList<String> priceList = new ArrayList<String>();
			String[] arr = null;
			
			
			
			
			// Iterate through the list of bike models and extract the required information
			for (int i = 0; i < bikeModelsElements.size(); i++) 
			{
				String s = bikeModelsElements.get(i);
				if (s.contains("Honda")) {
					nameList.add(s);
				}
				if (s.contains("Rs. ")) {
					arr = s.split(" ");
					priceList.add(arr[1]);
				}
				if (s.contains("Launch Date : ")) {
					dateList.add(s);
				}
			}
			
			// Wait for page elements to load
			try 
			{
				Thread.sleep(3000);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
	        
			// Initialize an ArrayList to store upcoming bikes with price less than 4 Lakhs
			ArrayList<String> upcomingBikes = new ArrayList<String>();
			if(nameList.size()>0) {for (int i = 0; i <nameList.size(); i++)
			{
				String temp = nameList.get(i);
				
				// Convert bike price to a double value
				if(priceList.get(i).contains("."))
				{
				NumberFormat format = NumberFormat.getInstance(Locale.FRANCE); // parse numbers in French-style format
				Number number = format.parse(priceList.get(i));
				double price = number.doubleValue();
				
				// Combine bike name, price and launch date to a single string
				
				
				if (Double.compare(price, 4d) < 0)
				info = temp + "  " + priceList.get(i) + " Lakh  " + dateList.get(i);
				
				// Check if bike name is present in the string and price is less than 4 Lakhs
				if (info.contains(temp)) 	
					{
						upcomingBikes.add(info);
						
					}
				}
				else
				{
					double amount1=Double.parseDouble(priceList.get(i).replace(",",""));
				if(amount1<limit)
				  {
					 info = temp + "  " + priceList.get(i) + " thousand " + dateList.get(i);
					 if (info.contains(temp)) 
					 {
							upcomingBikes.add(info);
				     }
				  }
			     }
			  }
			}
			
			// Print the list of upcoming bikes to the console
			System.out.println("Upcoming Honda Bikes Below 4 Lakhs are as follows:");
			for (int i = 0; i < upcomingBikes.size(); i++)
			{
				System.out.println(upcomingBikes.get(i));
				
			}
		
			ExcelUtils eu=new ExcelUtils();
			eu.writeData("bike models", upcomingBikes, 0, 0);

		}
}

		
		
		
		
