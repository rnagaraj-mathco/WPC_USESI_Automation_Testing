package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAppUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }
    
    public static String dashboardUrl() {
		return properties.getProperty("dashboardUrl");
	}
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

	public static String customerOverview() {
		return properties.getProperty("customerOverview");
	}

	public static String autorootOverview() {
		return properties.getProperty("autorootOverview");
	}

	public static String cpa_overview() {
		return properties.getProperty("cpa_overview");
	}

	public static String cpa_createScenario() {
		return properties.getProperty("cpa_CreateScenario");
	}

	public static String cpa_branchCustomerSelection() {
		return properties.getProperty("cpa_branchCustomerSelection");
	}

	public static String cpa_peerSelection() {
		return properties.getProperty("cpa_peerSelection");
	}
	public static String cpa_ScenarioImapct() {
		return properties.getProperty("cpa_ScenarioImapct");
	}
	

	

}
