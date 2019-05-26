import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumSession {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		File src = new File("src");
		File dest=new File(src,"ApiDemos-debug.apk");
		String appiumURL="http://0.0.0.0:4723/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");//Android Emulator 574c4e4755583398
		cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
		//cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\fakhr\\base.apk");
		cap.setCapability(MobileCapabilityType.APP,dest.getAbsolutePath() );
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		//cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		//cap.setCapability(MobileCapabilityType.APPLICATION_NAME, "com.gaana");
		
		/*cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "C:\\Users\\fakhr\\base.apk");
		cap.setCapability( "appPackage", "com.gaana");*/
		//cap.setCapability("appWaitActivity", "com.gaana/.SplashScreenActivity");
		//cap.setCapability( "appPackage", "com.gaana.GaanaActivity");
		//cap.setCapability("appWaitActivity", "com.gaana/.OnBoardLanguagePreferenceActivityNew");//cap.setCapability("appActivity", "com.gaana/.SplashScreenActivity");
		//cap.setCapability("automationName","Appium") ;//"UiAutomator2")
		// "platformVersion": "5.1.1",
		 //"fullReset": "false",
		//  "noReset": "true",
		// "appWaitActivity": "com.gaana/.SplashScreenActivity"
		AndroidDriver<MobileElement> driver=new AndroidDriver<MobileElement>(new URL(appiumURL), cap);
		//driver.wait(5000);
		
		//driver.findElement(By.id("com.gaana:id/menu_icon")).click();
		List<MobileElement> listStr = driver.findElementsByClassName("android.widget.TextView");
	    //int i= listStr.size();
	    for(int j=0;j<listStr.size();j++)
	    {
	    	System.out.println(listStr.get(j).getText());
	    }
	    
	    /*TouchActions tc=new TouchActions(driver);
	    tc.scroll(driver.findElementById("android:id/text1"), 0, 0);
	    */
	    driver.findElementById("android:id/text1").click();
	}

}
