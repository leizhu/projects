package pa.tempest.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.BrowserLauncher;
import core.Configuration;


public class TempestInstallTest {
	WebDriver driver = null;
		
	@BeforeTest
	public void setup() {
		driver = BrowserLauncher.initBrowser();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	}
	
	@Test
	public void installTempest() throws InterruptedException {
		// first login
		System.out.println("1) Log into PA.");
		TempestLogin tempestLogin = new TempestLogin(driver);
		tempestLogin.logintoTempest();
		
		// add new PA component in UI
		System.out.println("2) select latest PA version.");
		
		System.out.println("2.1) remove old PA component.");
		AddAnalyticsComponent addPA = new AddAnalyticsComponent(driver);
		addPA.removeOldComponentFromUI();
		
		System.out.println("2.2) click 'Install updates' to make old PA to be uninstalled.");
		WebElement installUpdateElement = driver.findElement(By.id("deploy-action"));
		installUpdateElement.click();
		if (driver.findElements(By.id("ignore-deploy-action")).size() !=0 ) {
			WebElement ignoreIconElement = driver.findElement(By.id("ignore-deploy-action"));
			ignoreIconElement.click();
		}
		checkStatusOfUnInstallation();
		
		System.out.println("2.3) select latest PA component version.");
		driver.navigate().to(driver.getCurrentUrl());
		addPA.addNewAnalyticsComponent();
		
		// config PA setting
		System.out.println("3) config PA setting.");
		ConfigAnalytics configPA = new ConfigAnalytics(driver);
		configPA.configAnalytics();
		configPA.configNetwork();
		configPA.configPHD();
		configPA.configCF();
		
		// go to main page
		driver.navigate().to(Configuration.getConfigurationInstance().getTempestURL());
		
//		// import config files
//		System.out.println("3) Import existing config file.");
//		ActionSetting actionSetting = new ActionSetting(driver);
//		actionSetting.importConfig();
		
		// install tempest 
		System.out.println("4) Install PA.");
		WebElement deployElement = driver.findElement(By.id("deploy-action"));
		deployElement.click();
		if (driver.findElements(By.id("ignore-deploy-action")).size() !=0 ) {
			WebElement ignoreIconElement = driver.findElement(By.id("ignore-deploy-action"));
			ignoreIconElement.click();
		}
		
		// check whether install is ongoing 
		System.out.println("5) Check whether PA is installed.");
		String currentURL = driver.getCurrentUrl();
		if (currentURL.contains("deploy") == false) {
			System.err.println("Deployment is NOT triggered!");
			throw new AssertionError("Deployment is NOT triggered!"); 
		}
		WebElement progressElement = driver.findElement(By.id("deploy-progress-bar"));
		if (progressElement.isDisplayed() == false) {
			System.err.println("Something wrong in the configurations!");
			throw new AssertionError("Something wrong in the configurations!"); 
		}
		
		// check status of installation
		checkStatusOfInstallation();
	}
	
	private void checkStatusOfUnInstallation() throws InterruptedException {
		int elapseTime = 0;
		while (elapseTime<=Configuration.getConfigurationInstance().getUninstallWaitingTime()) {
			Thread.sleep(60*1000);
			WebElement successDialog = driver.findElement(By.id("deploy-success-modal"));
			if (successDialog.isDisplayed())
				break;
			elapseTime += 1;			
		}
		
		if (elapseTime > Configuration.getConfigurationInstance().getDeployWaitingTime()) {
			System.err.println("Exceed the waiting time, uninstallation is still not completed!");
			throw new AssertionError("Exceed the waiting time, uninstallation is still not completed!"); 
		}
		
		System.out.println(">>>Uninstallation is completed!<<<");
	}

	private void checkStatusOfInstallation() throws InterruptedException{		
		int elapseTime = 0;
		while (elapseTime<=Configuration.getConfigurationInstance().getDeployWaitingTime()) {
			Thread.sleep(60*1000);
			WebElement successDialog = driver.findElement(By.id("deploy-success-modal"));
			if (successDialog.isDisplayed())
				break;
			elapseTime += 1;			
		}
		
		if (elapseTime > Configuration.getConfigurationInstance().getDeployWaitingTime()) {
			System.err.println("Exceed the waiting time, deployments is still not completed!");
			throw new AssertionError("Exceed the waiting time, deployments is still not completed!"); 
		}
		
		System.out.println(">>>Deployment is completed!<<<");
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
