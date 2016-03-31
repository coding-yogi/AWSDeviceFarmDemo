package com.ui.pageobjects.autodesk.accounts;

import com.framework.core.Wrappers;
import com.framework.handlers.XMLHandler;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Element;

import java.io.InputStream;

public class LaunchApplication {

	private WebDriver driver;
	private Wrappers objWrapper;
	private XMLHandler xmlHandler;

	public LaunchApplication(WebDriver driver){
		this.driver = driver;
		this.objWrapper = new Wrappers(this.driver);

		InputStream inputStream = this.getClass().getResourceAsStream("/environmentConfig.xml");
		this.xmlHandler = new XMLHandler(inputStream);
	}	
	
	public LoginPage launchIdentityApplication(){
		String url = ((Element)(xmlHandler.getElementByName("dev").getElementsByTagName("oxygen_url")).item(0)).getTextContent();
		driver.get(url);
		objWrapper.takeScreenshot("launchApplication");
		return new LoginPage(driver);
	}
}
