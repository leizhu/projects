package pa.tempest.test;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfigAnalytics {

	private Properties properties;
	WebDriver driver = null;
	
	public ConfigAnalytics(WebDriver driver) {
		this.driver = driver;
		
		String buildTop = System.getenv("BLD_TOP");
        String configFilePath = buildTop + "/config/pa.properties";

        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(configFilePath));
            properties = new Properties();
            properties.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        } catch (IOException e) {
            e.printStackTrace();  
        }
	}
	
	private String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	private void waitForSeconds(int seconds) {
		try {
			Thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void saveConfig() {
		WebElement saveBtnElement = driver.findElement(By.id("save-action"));
		saveBtnElement.click();
	}

	public void configAnalytics() {
		System.out.println("3.1) Config analytics");
		
		WebElement tabElement = driver.findElement(By.id("show-pa-action"));
		tabElement.click();
		
		// input pa admin account
		WebElement emailElement = driver.findElement(By.name("pa[pa_admin_credentials][identity]"));
		emailElement.sendKeys(getProperty("PAADMIN_EMAIL_VALUE"));
		WebElement pwdElement = driver.findElement(By.name("pa[pa_admin_credentials][password]"));
		pwdElement.sendKeys(getProperty("PAADMIN_PWD_VALUE"));

		saveConfig();
		waitForSeconds(5);
	}

	public void configNetwork() {
		System.out.println("3.2) Config network");
		
		WebElement tabElement = driver.findElement(By.id("show-messaging-action"));
		tabElement.click();
		
		// input smtp info
		WebElement hostElement = driver.findElement(By.name("messaging[smtp_address_port][address]"));
		hostElement.sendKeys(getProperty("SMTP_HOST_VALUE"));
		WebElement portElement = driver.findElement(By.name("messaging[smtp_address_port][port]"));
		portElement.clear();
		portElement.sendKeys(getProperty("SMTP_PORT_VALUE"));
		WebElement usrElement = driver.findElement(By.name("messaging[smtp_credentials][identity]"));
		usrElement.sendKeys(getProperty("SMTP_USR_VALUE"));
		WebElement pwdElement = driver.findElement(By.name("messaging[smtp_credentials][password]"));
		pwdElement.sendKeys(getProperty("SMTP_PWD_VALUE"));
		
		// input support email info
		WebElement emailElement = driver.findElement(By.name("messaging[support_email]"));
		emailElement.sendKeys(getProperty("SUPPORT_EMAIL_VALUE"));
		
		// input proxy info
		WebElement proxyHostElement = driver.findElement(By.name("messaging[proxy_address_port][address]"));
		proxyHostElement.sendKeys(getProperty("PROXY_HOST_VALUE"));
		WebElement proxyPortElement = driver.findElement(By.name("messaging[proxy_address_port][port]"));
		proxyPortElement.sendKeys(getProperty("PROXY_PORT_VALUE"));
		
		saveConfig();
		waitForSeconds(5);
	}

	public void configPHD() {
		System.out.println("3.3) Config PHD");
		
		WebElement tabElement = driver.findElement(By.id("show-query-action"));
		tabElement.click();
		
		// input hd version
		WebElement versionElement = driver.findElement(By.name("query[phd_version]"));
		versionElement.clear();
		versionElement.sendKeys(getProperty("PHD_VERSION_VALUE"));
		
		// input HDFS IP and port
		WebElement hdfsIPElement = driver.findElement(By.name("query[hdfs_address_port][address]"));
		hdfsIPElement.sendKeys(getProperty("HDFS_IP_VALUE"));
		WebElement hdfsPortElement = driver.findElement(By.name("query[hdfs_address_port][port]"));
		hdfsPortElement.clear();
		hdfsPortElement.sendKeys(getProperty("HDFS_PORT_VALUE"));
		
		// input hbase zookeeper hosts
		WebElement hbaseZookeeperHostsElement = driver.findElement(By.name("query[hbase_zookeeper_quorum]"));
		hbaseZookeeperHostsElement.sendKeys(getProperty("HBASE_ZOOKEEPER_VALUE"));
		
		// input hive server ip
		WebElement hiveServerIPElement = driver.findElement(By.name("query[hive_address_port][address]"));
		hiveServerIPElement.sendKeys(getProperty("HIVE_IP_VALUE"));
		
		// input resource manager ip
		WebElement resourceMgrIPElement = driver.findElement(By.name("query[yarn_resource_manager_address_port][address]"));
		resourceMgrIPElement.sendKeys(getProperty("RESOURCE_MGR_IP_VALUE"));
			
		saveConfig();
		waitForSeconds(5);
	}

	public void configCF() {
		System.out.println("3.4) Config CF");
		
		WebElement tabElement = driver.findElement(By.id("show-storm-action"));
		tabElement.click();
		
		// input controller URL
		WebElement urlElement = driver.findElement(By.name("storm[cc_url]"));
		urlElement.sendKeys(getProperty("CC_URL_VALUE"));
		
		// input CC token
		WebElement tokenElement = driver.findElement(By.name("storm[cc_auth_token]"));
		tokenElement.sendKeys(getProperty("CC_TOKEN_VALUE"));
		
		// input CF credential
		WebElement usrElement = driver.findElement(By.name("storm[cf_credentials][identity]"));
		usrElement.sendKeys(getProperty("CF_LOGIN_USR_VALUE"));
		WebElement pwdElement = driver.findElement(By.name("storm[cf_credentials][password]"));
		pwdElement.sendKeys(getProperty("CF_LOGIN_PWD_VALUE"));
		
		saveConfig();
		waitForSeconds(5);
	}

}
