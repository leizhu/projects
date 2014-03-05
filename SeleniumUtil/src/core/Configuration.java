package core;


import java.io.*;
import java.util.Properties;

public class Configuration {

    private Properties properties;

    private String browserType;
    private String defaultSystem;
    private String tempestURL;
    private String importedConfigFile;
    private int deployWaitingTime;
    private int uninstallWaitingTime;
    

    private static Configuration configInstance = new Configuration();

    public static Configuration getConfigurationInstance() {
        return configInstance;
    }

    private Configuration() {
        if (configInstance == null) {
            String buildTop = System.getenv("BLD_TOP");

            String configFilePath = buildTop + "/config/config.properties";

            InputStream in = null;
            try {
                in = new BufferedInputStream(new FileInputStream(configFilePath));
                properties = new Properties();
                properties.load(in);
                
                browserType = properties.getProperty("BrowserType");
                defaultSystem = properties.getProperty("DefaultSystem");
                tempestURL = properties.getProperty("TempestURL");
                importedConfigFile = properties.getProperty("ImportedConfigFile");
                deployWaitingTime = Integer.parseInt(properties.getProperty("DeployWaitingTime"));
                uninstallWaitingTime = Integer.parseInt(properties.getProperty("UninstallWaitingTime"));

            } catch (FileNotFoundException e) {
                e.printStackTrace();  
            } catch (IOException e) {
                e.printStackTrace();  
            }
        }
    }

	public String getBrowserType() {
		return browserType;
	}
	
	public String getDefaultSystem() {
		return defaultSystem;
	}
	
	public String getTempestURL() {
		return tempestURL;
	}
	
	public String getImportedConfigFile() {
		return importedConfigFile;
	}
	
	public int getDeployWaitingTime() {
		return deployWaitingTime;
	}
	
	public int getUninstallWaitingTime() {
		return uninstallWaitingTime;
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static void main(String []args) {
		System.out.println(Configuration.getConfigurationInstance().getBrowserType());
		
		String test = "component_type=analytics&component_version=3";
		String num = test.substring(test.lastIndexOf("=")+1, test.length());
		System.out.println(Integer.parseInt(num));
		String verString = String.valueOf(Integer.parseInt(num));
		System.out.println(verString);
	}

    public void waitForTime(int i) {
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
