package wikia.scenarios;

import java.io.IOException;

import wikia.webdriver.Drivers;

public class Scenario1 {

	public void Run(String browser) throws IOException {
		
		Drivers.DriverInit(browser);
		
		Drivers.GoTo(browser, "http://wikia.com");

		Drivers.MouseHoover(Drivers.FindByTagNameAndAttributeIndexed("SPAN",
				"textContent", "Sign In", 0));

		Drivers.sendKeysByName("username", "wikiadk");

		Drivers.sendKeysByName("password", "mywikia123");

		Drivers.ClickByTagNameAndAttribute("INPUT", "defaultValue", "Log in");
		
		Drivers.DriverWait(10000);

		// validate user logged in
		Drivers.IsPresentByTagNameAndAttribute("DIV", "className",
				"avatar-container logged-avatar-placeholder");

		Drivers.BrowserQuit();

	}

}
