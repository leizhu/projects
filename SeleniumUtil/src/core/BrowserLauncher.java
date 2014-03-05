
package core;

//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import core.Constants.BROWSERTYPE;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class BrowserLauncher {
	//private static Logger logger = LoggerHandler.getLoggerHandlerInstance().getCurrentLogger();//Logger.getLogger("DEFAULT_LOGGER");

	private static WebDriver driver = null;
	private static ChromeDriverService service;
	

	public static WebDriver initBrowser() {
		Constants.BROWSERTYPE browserType = getBrowserType(Configuration.getConfigurationInstance().getBrowserType());
	    driver = getWebDriver(browserType);
	    driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_SECONDS_IMPLICIT, TimeUnit.SECONDS);
		return driver;
	}

	private static BROWSERTYPE getBrowserType(String browserType) {
		if(browserType.equalsIgnoreCase("chrome"))
			return BROWSERTYPE.CHROME;
		else if(browserType.equalsIgnoreCase("firefox"))
			return BROWSERTYPE.FIREFOX;
		else if(browserType.equalsIgnoreCase("ie"))
			return BROWSERTYPE.IE;
		else 
			return BROWSERTYPE.CHROME;
	}

	public static void closeBrowser(Constants.BROWSERTYPE Type) {
	   
		switch (Type) {
	        case FIREFOX:
		        // Need to implement
	        	driver.quit();
		        break;
	        case IE:
	        	// Need to implement
	        	driver.quit();
		        break;
	        case CHROME:
	        	driver.quit();
	    		service.stop();
	    		break;     
	        case HTMLUNIT:
	            // Need to implement
	            
	        case SAFARI:
	            // Need to implement
	            
	        default:{
	        	System.err.println("Browser type unsupported");
	        	throw new RuntimeException("Browser type unsupported");
	        }
		}
	    
	}

	@SuppressWarnings("deprecation")
	private static WebDriver getWebDriver(Constants.BROWSERTYPE browserType) {
	    WebDriver d= null; 
		switch (browserType) {
	        case FIREFOX: 
	        	d = new FirefoxDriver();
	        	break;
	            
	        case IE:
	        	d = new InternetExplorerDriver();
	        	break;
	            
	        case CHROME:
	        	try {
	    			// WebDriver driver = new ChromeDriver();
	        		String buildTop = System.getenv("BLD_TOP");
	        		String chromeDriverPath;
	        		if(Configuration.getConfigurationInstance().getDefaultSystem().equalsIgnoreCase("Mac"))
	        			chromeDriverPath = buildTop + "/tools/chromedriver";
	        		else 
	        			chromeDriverPath = buildTop + "/tools/chromedriver.exe";
	    			service = new ChromeDriverService.Builder()
	    	        .usingChromeDriverExecutable(new File(chromeDriverPath))
	    	        .usingAnyFreePort()
	    	        .build();
	    			service.start();
	    			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    			capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized","--ignore-certificate-errors"));
	    			//"--ignore-certificate-errors"
	    			d = new RemoteWebDriver(service.getUrl(), capabilities);	
	    			System.out.println("Create webdriver for chrome successfully!");
	        	}catch (Exception e) {
	        		System.err.println(e.getMessage());
	    			e.printStackTrace();
	    			return null;
	    		}
	        	break;
	        case HTMLUNIT:
	            // Need to implement
	        	break;
	        case SAFARI:
	            // Need to implement
	        	break;
	        default:
	        	System.err.println("Browser type unsupported");
	            throw new RuntimeException("Browser type unsupported");
	    }
	    return d;
	}

}
