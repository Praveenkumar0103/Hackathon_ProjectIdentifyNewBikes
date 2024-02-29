package factory;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

	public class BaseClass {

			 static WebDriver driver;
		     static Properties p;
		     static Logger logger;
		  	     
		@SuppressWarnings("deprecation")
		public static WebDriver initilizeBrowser() throws IOException
		{
			if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				
				//os
				if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				    capabilities.setPlatform(Platform.WIN11);
				} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				    capabilities.setPlatform(Platform.MAC);
				} else {
				    System.out.println("No matching OS..");
				      }
				//browser
				switch (getProperties().getProperty("browser").toLowerCase()) {
				    case "chrome":
				        capabilities.setBrowserName("chrome");
				        break;
				    case "edge":
				        capabilities.setBrowserName("MicrosoftEdge");
				        break;
				    default:
				        System.out.println("No matching browser");
				     }
		       
		        driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
				
			}
			else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
				{
					switch(getProperties().getProperty("browser").toLowerCase()) 
					{
					case "chrome":
				        driver=new ChromeDriver();
				        break;
				    case "edge":
				    	driver=new EdgeDriver();
				        break;
				    default:
				        System.out.println("No matching browser");
				        driver=null;
					}
				}
			 driver.manage().deleteAllCookies(); 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
			 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			 driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(30));
			 
			 return driver;
			 
		}
		
		public static WebDriver getDriver() {
				return driver;
			}

		public static Properties getProperties() throws IOException
		{		 
	        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	       		
	        p=new Properties();
			p.load(file);
			return p;
		}
		
		public static Logger getLogger() 
		{		 
			logger=LogManager.getLogger(); //Log4j
			return logger;
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
