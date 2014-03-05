package pa.tempest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.Configuration;

public class TempestLogin {

	WebDriver driver = null;
	
	public TempestLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void logintoTempest() {
		driver.get(Configuration.getConfigurationInstance().getTempestURL());
		
		
		WebElement userNameElement = driver.findElement(By.name("login[user_name]"));
		userNameElement.sendKeys("admin");
		WebElement passwordElement = driver.findElement(By.name("login[password]"));
		passwordElement.sendKeys("admin");
		
		WebElement loginElement = driver.findElement(By.id("login-action"));
		loginElement.click();
	}
}
