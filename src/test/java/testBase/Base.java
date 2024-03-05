package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Base
{
	public Logger logger;
	public static WebDriver driver;
	
    public Properties p;
	
    // Method to set up the WebDriver instance based on the browser
	@BeforeClass(groups={"smoke","regression"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException  {
		logger= LogManager.getLogger(this.getClass());
		
		FileInputStream	file = new FileInputStream("src/test/resources/config.properties");
		
		p = new Properties();
		p.load(file);
		
		
		// Chrome browser
		if(br.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver(); 
		}
		// Edge browser
		else if(br.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver(); 
		}
		else {
			System.out.println("Its Not Vaild Browser");
		}		
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	// Method to quit the browser

	@AfterClass(groups={"smoke","regression"})
	public void teardown() 
	{
		driver.quit();
	}
	
	// Taking Screenshot
	public String captureScreen(String name) 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

	
}


	
	
