package pa.tempest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.Configuration;

public class ActionSetting {
	WebDriver driver = null;
	
	public ActionSetting(WebDriver driver) {
		this.driver = driver;
	}
	
	private void clickActions(String actionType) {
		WebElement actionElement = driver.findElement(By.id("show-actions-dropdown-action"));
		actionElement.click();
		if (actionType.equalsIgnoreCase("import")) {
			WebElement importElement = driver.findElement(By.id("show-import-action"));
			importElement.click();
		}
		if (actionType.equalsIgnoreCase("export")) {
			WebElement exportElement = driver.findElement(By.id("export-action"));
			exportElement.click();
		}
	}
	

	
	public void importConfig() {
		clickActions("import");
		// select config file
		String configFile = Configuration.getConfigurationInstance().getImportedConfigFile();
		String absolutePath = System.getenv("BLD_TOP")+"/config/"+configFile;
		WebElement chooseFileElement = driver.findElement(By.name("import[file]"));
		chooseFileElement.sendKeys(absolutePath);
		
		// click import button
		WebElement importElement = driver.findElement(By.id("import-action"));
		importElement.click();
		
		// check if importation is successful
		String currentURL = driver.getCurrentUrl();
		if (currentURL.contains("import")) {
			System.err.println("Can not import this config file: "+absolutePath);
			throw new AssertionError("Can not import this config file: "+absolutePath); 
		}
	}

	public void exportConfig() {
		clickActions("export");
	}
	
}
