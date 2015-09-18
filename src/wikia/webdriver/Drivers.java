package wikia.webdriver;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class Drivers {

	private static WebDriver driver = null;

	public static WebDriver firefox() throws IOException {

		FirefoxProfile firefoxProfile = new FirefoxProfile();
		/*
		 * we can add profile settings here later example below
		 * firefoxProfile.setPreference(
		 * "browser.download.manager.showWhenStarting", false);
		 * firefoxProfile.setPreference("browser.download.dir", "c:\temp");
		 * firefoxProfile.setPreference(
		 */
		driver = new FirefoxDriver(firefoxProfile);// new RemoteWebDriver

		return driver;

	}

	
	public static WebDriver chrome() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:/selenium/chrome_driver/chromedriver/chromedriver.exe");
		System.out.println(System.getProperty("webdriver.chrome.driver"));

		driver = new ChromeDriver();

		return driver;

	}

	public static void DriverInit(String browser) throws IOException {
		if (String.valueOf(browser).equals("firefox")){
			driver=firefox();}
		else{
			driver=chrome();
		}
		
		DriverReport("Driver Init: " + browser);

	}
	
	public static WebDriver GoTo(String browser,
			String urlName) throws IOException {
//		if (String.valueOf(browser).equals("firefox")){
//			driver=firefox();}
//		else{
//			driver=chrome();
//		}
		
		driver.get(urlName);
		
		DriverReport("Navigate to: " + urlName);
		
		return driver;

	}

	public static void BrowserQuit() throws IOException {

		driver.quit();

		DriverReport("Quiting browser...");

		DriverWait(300);
	}

	public static void MouseHooverParentAndChildClick(WebElement element1,
			String tagName, String attribute, String attValue) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element1).build().perform();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
			List<WebElement> elements = driver
					.findElements(By.tagName(tagName));
			for (WebElement element : elements) {
				if (element.getAttribute(attribute).equals(attValue)) {
					element.click();
					DriverReport("Hoover mouse over: " + attValue);
					break;
				}
			}

		} catch (Exception e) {

		}

	}

	public static void MouseHoover(WebElement element) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		DriverReport("Hoover mouse over element");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			DriverReport("Error: " + e.getMessage());
		}
	}

	public static WebElement FindByTagNameAndAttributeIndexed(String tag,
			String attribute, String value, int index) {
		List<WebElement> elements = driver.findElements(By.tagName(tag));

		int i = 0;
		for (WebElement element : elements) {
			String attvalue = element.getAttribute(attribute);
			if (attvalue.equals(value)) {
				if (index == i) {
					return element;
				}
				i++;
			}
		}
		return null;
	}

	public static void DriverWait(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DriverReport("Error: " + e.getMessage());
		}
	}

	public static void DriverReport(String textmessage) {
		System.out.println(textmessage);
	}

	public static WebElement ClickByTagNameAndAttribute(String tag,
			String attribute, String value) {

		try {

			List<WebElement> elements = driver.findElements(By.tagName(tag));
			for (WebElement element : elements) {
				if (element.getAttribute(attribute).equals(value)) {
					try {
						DriverReport("Clicking on: " + value);
						element.click();
					} catch (Exception e) {
						DriverReport("Error: " + e.getMessage());
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					return element;
				}
			}

			return null;

		} catch (Exception e) {
			DriverReport("Error: " + e.getMessage());
			return null;

		}

	}

	public static void sendKeysByName(String name, String keys) {
		try {
			driver.findElement(By.name(name)).sendKeys(keys);
			DriverReport("Entering value: " + keys);
		} catch (Exception e) {
			DriverReport("Error: " + e.getMessage());
		}

	}

	public static void IsPresentByTagNameAndAttribute(String tag,
			String attribute, String value) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DriverReport("Error: " + e.getMessage());
		}

		List<WebElement> elements = driver.findElements(By.tagName(tag));
		for (WebElement element : elements) {
			if (element.getAttribute(attribute).equals(value)) {
				DriverReport("Element is present: " + value);
				return;
			}
		}

		DriverReport("Element is not present: " + value);
	}

	public static Boolean FoundByTagNameAndAttribute(String tag,
			String attribute, String value) {

		List<WebElement> elements = driver.findElements(By.tagName(tag));
		for (WebElement element : elements) {
			if (element.getAttribute(attribute).equals(value)) {
				return true;
			}
		}

		return false;
	}

	public static void idleOnDiscovery(String tagName, String attribute,
			String value, int maxCounter, Boolean waitWhileFound) {
		int counter = 0;

		DriverWait(3000);

		while (counter < maxCounter) {
			if (FoundByTagNameAndAttribute(tagName, attribute, value) == waitWhileFound) {
				try {
					Thread.sleep(10000);
					counter++;
				} catch (InterruptedException e) {
					DriverReport("Error: " + e.getMessage());

				}
				if (counter == maxCounter) {
					DriverReport("Wait time reached max=" + maxCounter);

				}
			} else {
				counter = maxCounter;
			}
		}
		DriverWait(3000);

	}
}
