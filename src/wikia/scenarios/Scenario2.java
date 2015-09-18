package wikia.scenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import wikia.webdriver.Drivers;

public class Scenario2 {

	public void Run(String browser) throws IOException {
		
		
		Drivers.DriverReport("Scenario 2 - test begins");
		
		Drivers.DriverInit(browser);
		
		Drivers.GoTo(browser, "http://wikia.com");
		
		Drivers.DriverWait(3000);

		Drivers.MouseHoover(Drivers.FindByTagNameAndAttributeIndexed("SPAN",
				"textContent", "Sign In", 0));

		Drivers.sendKeysByName("username", "wikiadk");

		Drivers.sendKeysByName("password", "mywikia123");

		Drivers.ClickByTagNameAndAttribute("INPUT", "defaultValue", "Log in");
		
		Drivers.DriverWait(10000);
		
		Drivers.GoTo(browser, "http://wikiadk.wikia.com/wiki/Wikiadk_Wikia");

		Drivers.IsPresentByTagNameAndAttribute("DIV", "className",
				"avatar-container logged-avatar-placeholder");
		
		Drivers.ClickByTagNameAndAttribute("NAV", "className", "wikia-menu-button contribute secondary combined");
		
		Drivers.ClickByTagNameAndAttribute("a", "text", "Add a Video");
		
		Drivers.DriverWait(20000);
		
		Drivers.sendKeysByName("wpWikiaVideoAddUrl", "http://www.youtube.com/watch?v=h9tRIZyTXTI");
		
		Drivers.ClickByTagNameAndAttribute("INPUT", "value", "Add");
		
		Drivers.idleOnDiscovery("DIV", "className",
				"msg",30, false);
		
		Drivers.IsPresentByTagNameAndAttribute("A", "innerHTML",
				"File:The Best Classical Music In The World");
		
		Drivers.ClickByTagNameAndAttribute("A", "innerHTML", "File:The Best Classical Music In The World");
		
		Drivers.idleOnDiscovery("A", "id",
				"ca-edit",30, false);
		
		Drivers.IsPresentByTagNameAndAttribute("H1", "innerHTML",
				"The Best Classical Music In The World");
		

		Drivers.BrowserQuit();
		
		Drivers.DriverReport("Scenario 2 - test ends");


	}

}
