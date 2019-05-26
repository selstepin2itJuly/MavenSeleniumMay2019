package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	private static WebDriver driver;//class or static variable
	private static String browser;
	private static String url;
	public static Properties prop;
	
	public static WebDriver init() throws IOException {
		
		Reader inStream=new FileReader("./src/main/java/config/config.properties");
		prop=new Properties();
		prop.load(inStream);
		
		browser=prop.getProperty("browser");
		url=prop.getProperty("url");
		if(browser.equalsIgnoreCase("chrome")) 
		{
			String key ="webdriver.chrome.driver";
			String value="./drivers/chromedriver.exe";
			System.setProperty(key, value);
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			String key ="webdriver.gecko.driver";
			String value="./drivers/geckodriver.exe";
			System.setProperty(key, value);
			driver=new FirefoxDriver();	
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else if(browser.equalsIgnoreCase("IE")) {
			//To Do
		}else {
			Throwable th=new Throwable();
			th.initCause(null);
		}
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
