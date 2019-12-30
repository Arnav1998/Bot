package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridGenerator {
	
	private WebDriver driver;
	private String nodeURL;
	
	public GridGenerator(String browserName, String nodeURL) throws MalformedURLException {
	
		this.nodeURL = nodeURL;
		
		if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "/Users/arnav/Selenium/geckodriver");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			this.driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
			
		} else if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.gecko.driver", "/Users/arnav/Selenium/chromedriver");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			this.driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
			
		}
		
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public String getNodeURL() {
		return this.nodeURL;
	}
	

}
