package pa.tempest.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddAnalyticsComponent {
	WebDriver driver = null;
	
	public AddAnalyticsComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	private void waitForSeconds(int seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// remove old version of PA 
	public void removeOldComponentFromUI() {
		if (driver.findElements(By.id("open-delete-analytics-modal")).size() !=0 ) {
			WebElement deleteIconElement = driver.findElement(By.id("open-delete-analytics-modal"));
			deleteIconElement.click();
			// wait for 5 seconds
			waitForSeconds(5);
			// confirm to delete PA component in UI
			WebElement confirmBtnElement = driver.findElement(By.id("delete-analytics-action"));
			confirmBtnElement.click();
			waitForSeconds(5);
		}
	}

	public void addNewAnalyticsComponent() {
		waitForSeconds(5);
		// click add icon in main page		 
		WebElement addIconElement = driver.findElement(By.id("add-product-action"));
		addIconElement.click();
		
		int latestVersion = 1;
		List<WebElement> elements=driver.findElements(By.xpath("//a[starts-with(@href,'/components?component_type=analytics&component_version=')]"));	
		for (int i = 0; i < elements.size(); i++) {
			WebElement element = elements.get(i);
			String hrefValue = element.getAttribute("href");
			
			String num = hrefValue.substring(hrefValue.lastIndexOf("=")+1, hrefValue.length());
			int ver = Integer.parseInt(num);
			if (ver > latestVersion) latestVersion = ver;
		}
		String version = String.valueOf(latestVersion);
		String xpathForLatestVersion = "//a[starts-with(@href,'/components?component_type=analytics&component_version="+version+"')]";
		WebElement latestPAElement = driver.findElement(By.xpath(xpathForLatestVersion));
		latestPAElement.click();
		
		// check whether the latest PA is selected
		String currentURL = driver.getCurrentUrl();
		if (currentURL.indexOf("pa/edit") == -1){
			System.err.println("Latest PA version is not selected!");
			throw new AssertionError("Latest PA version is not selected!"); 
		}
	}
	
	
}