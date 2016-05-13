package com.framework.core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Wrappers {

	private WebDriver driver;
	
	//Constructor
	public Wrappers(WebDriver driver)
	{
		this.driver = driver;
	}

    //*****************************************************************************************
    //*	Name		    : getElement
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public WebElement getElement(String objDesc)
    {
        //Delimiters
        String[] delimiters = new String[] {":="};
        String[] arrFindByValues = objDesc.split(delimiters[0]);

        //Get Findby and Value
        String FindBy = arrFindByValues[0];
        String val = arrFindByValues[1];

        //Handle all FindBy cases
        String strElement = FindBy.toLowerCase();

        try{
            if (strElement.equalsIgnoreCase("id"))
            {
                return driver.findElement(By.id(val));
            }
            else if (strElement.equalsIgnoreCase("name"))
            {
                return driver.findElement(By.name(val));
            }
            else if (strElement.equalsIgnoreCase("linktext"))
            {
                return driver.findElement(By.linkText(val));
            }
            else if (strElement.equalsIgnoreCase("classname"))
            {
                return driver.findElement(By.className(val));
            }
            else if (strElement.equalsIgnoreCase("cssselector"))
            {
                return driver.findElement(By.cssSelector(val));
            }
            else if (strElement.equalsIgnoreCase("xpath"))
            {
                return driver.findElement(By.xpath(val));
            }
            else if (strElement.equalsIgnoreCase("accessibility_id"))
            {
                return ((AppiumDriver)driver).findElement(MobileBy.AccessibilityId(val));
            }
            else if (strElement.equalsIgnoreCase("appclassname"))
            {
                return ((AppiumDriver)driver).findElement(By.className(val));
            }
            else if (strElement.equalsIgnoreCase("uiautomator"))
            {
                return ((AppiumDriver)driver).findElement(MobileBy.AndroidUIAutomator(val));
            }
            else if (strElement.equalsIgnoreCase("partiallinktext"))
            {
                return driver.findElement(By.partialLinkText(val));
            }
            else if (strElement.equalsIgnoreCase("tagname"))
            {
                return driver.findElement(By.tagName(val));
            }
            else
            {
                throw(new InvalidSelectorException("Wrapper method getElement() : Property "  + FindBy + " specified for element is invalid"));
            }
        }
        catch(NoSuchElementException ex){
            throw(ex);
        }

    }

    //*****************************************************************************************
    //*	Name		    : getElements
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public List<WebElement> getElements(String objDesc)
    {
        //Delimiters
        String[] delimiters = new String[] {":="};
        String[] arrFindByValues = objDesc.split(delimiters[0]);

        //Get Findby and Value
        String FindBy = arrFindByValues[0];
        String val = arrFindByValues[1];

        List<WebElement> elements = null;

        //Handle all FindBy cases
        String strElement = FindBy.toLowerCase();
        if (strElement.equalsIgnoreCase("linktext")){
            elements = driver.findElements(By.linkText(val));
        }
        else if (strElement.equalsIgnoreCase("partiallinktext")){
            elements = driver.findElements(By.partialLinkText(val));
        }
        else if (strElement.equalsIgnoreCase("xpath")){
            elements = driver.findElements(By.xpath(val));
        }
        else if (strElement.equalsIgnoreCase("name")){
            elements = driver.findElements(By.name(val));
        }
        else if (strElement.equalsIgnoreCase("id")){
            elements = driver.findElements(By.id(val));
        }
        else if (strElement.equalsIgnoreCase("classname")){
            elements = driver.findElements(By.className(val));
        }
        else if (strElement.equalsIgnoreCase("cssselector")){
            elements = driver.findElements(By.cssSelector(val));
        }
        else if (strElement.equalsIgnoreCase("tagname")){
            elements = driver.findElements(By.tagName(val));
        }
        else if (strElement.equalsIgnoreCase("accessibility_id")){
            elements = ((AppiumDriver)driver).findElements(MobileBy.AccessibilityId(val));
        }
        else if (strElement.equalsIgnoreCase("appclassname")){
            elements = ((AppiumDriver)driver).findElements(By.className(val));
        }
        else{
            throw(new InvalidSelectorException("Wrapper method getElements() : Property "  + FindBy + " specified for element is invalid"));
        }

        return elements;
    }

    //*****************************************************************************************
    //*	Name		    : getChildElement
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public WebElement getChildElement(WebElement parentElem, String objDesc)
    {
        //Delimiters
        String[] delimiters = new String[] {":="};
        String[] arrFindByValues = objDesc.split(delimiters[0]);

        //Get Findby and Value
        String FindBy = arrFindByValues[0];
        String val = arrFindByValues[1];

        //Handle all FindBy cases
        String strElement = FindBy.toLowerCase();
        if (strElement.equalsIgnoreCase("id")) {
            return parentElem.findElement(By.id(val));
        }
        else if (strElement.equalsIgnoreCase("name")) {
            return parentElem.findElement(By.name(val));
        }
        else if (strElement.equalsIgnoreCase("linktext")){
            return parentElem.findElement(By.linkText(val));
        }
        else if (strElement.equalsIgnoreCase("classname")){
            return parentElem.findElement(By.className(val));
        }
        else if (strElement.equalsIgnoreCase("cssselector")){
            return parentElem.findElement(By.cssSelector(val));
        }
        else if (strElement.equalsIgnoreCase("xpath")){
            return parentElem.findElement(By.xpath(val));
        }
        else if (strElement.equalsIgnoreCase("accessibility_id")){
            return parentElem.findElement(MobileBy.AccessibilityId(val));
        }
        else if (strElement.equalsIgnoreCase("appclassname")){
            return parentElem.findElement(By.className(val));
        }
        else if (strElement.equalsIgnoreCase("uiautomator")){
            return parentElem.findElement(MobileBy.AndroidUIAutomator(val));
        }
        else if (strElement.equalsIgnoreCase("partiallinktext")){
            return parentElem.findElement(By.partialLinkText(val));
        }
        else if (strElement.equalsIgnoreCase("tagname")){
            return parentElem.findElement(By.tagName(val));
        }
        else{
            throw(new InvalidSelectorException("Wrapper method getChildElement() : Property "  + FindBy + " specified for element is invalid"));
        }
    }

    //*****************************************************************************************
    //*	Name		    : getChildElements
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public List<WebElement> getChildElements(WebElement parentElem, String objDesc)
    {
        //Delimiters
        String[] delimiters = new String[] {":="};
        String[] arrFindByValues = objDesc.split(delimiters[0]);

        //Get Findby and Value
        String FindBy = arrFindByValues[0];
        String val = arrFindByValues[1];

        //List
        List<WebElement> elements = null;

        //Handle all FindBy cases
        String strElement = FindBy.toLowerCase();
        if (strElement.equalsIgnoreCase("id")){
            elements = parentElem.findElements(By.id(val));
        }
        else if (strElement.equalsIgnoreCase("name")){
            elements = parentElem.findElements(By.name(val));
        }
        else if (strElement.equalsIgnoreCase("linktext")){
            elements = parentElem.findElements(By.linkText(val));
        }
        else if (strElement.equalsIgnoreCase("classname")){
            elements = parentElem.findElements(By.className(val));
        }
        else if (strElement.equalsIgnoreCase("cssselector")){
            elements = parentElem.findElements(By.cssSelector(val));
        }
        else if (strElement.equalsIgnoreCase("xpath")){
            elements = parentElem.findElements(By.xpath(val));
        }
        else if (strElement.equalsIgnoreCase("accessibility_id")){
            elements = parentElem.findElements(MobileBy.AccessibilityId(val));
        }
        else if (strElement.equalsIgnoreCase("appclassname")){
            elements = parentElem.findElements(By.className(val));
        }
        else if (strElement.equalsIgnoreCase("uiautomator")){
            elements = parentElem.findElements(MobileBy.AndroidUIAutomator(val));
        }
        else if (strElement.equalsIgnoreCase("partiallinktext")){
            elements = parentElem.findElements(By.partialLinkText(val));
        }
        else if (strElement.equalsIgnoreCase("tagname")){
            elements = parentElem.findElements(By.tagName(val));
        }
        else{
            throw(new InvalidSelectorException("Wrapper method getChildElements() : Property "  + FindBy + " specified for element is invalid"));
        }

        return elements;
    }


    //*****************************************************************************************
    //*	Name		    : isWebElementPresent
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
	public boolean isWebElementPresent(String strDesc){
        List<WebElement> lst = getElements(strDesc);
        boolean isPresent = (lst == null || lst.size() == 0) ? false : true;
        
        return isPresent;
    }


    //*****************************************************************************************
    //*	Name		    : isChildWebElementPresent
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
	public boolean isChildWebElementPresent(WebElement objParent, String strDesc){
        List<WebElement> lst = getChildElements(objParent,strDesc);
        boolean isPresent = (lst == null || lst.size() == 0) ? false : true;
        
        return isPresent;
    }
	
	//*****************************************************************************************
    //*	Name		    : isWebElementDisplayed
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
	public boolean isWebElementDisplayed(String strDesc) throws InterruptedException {
        WebElement webElement = getElement(strDesc);
        return isWebElementDisplayed(webElement);
    }
	
	//*****************************************************************************************
    //*	Name		    : isWebElementDisplayed
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
	public boolean isWebElementDisplayed(WebElement webElement) throws InterruptedException {
        boolean bIsDisplayed = webElement.isDisplayed();
        String state = bIsDisplayed ? "displayed" : "not displayed";
        String strDesc = webElement.toString();

        return  bIsDisplayed;
    }

	//*****************************************************************************************
    //*	Name		    : isWebElementEnabled
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public boolean isWebElementEnabled(String strDesc) throws InterruptedException {
        //Get WebElement
        WebElement webElement = getElement(strDesc);
        return isWebElementEnabled(webElement);
    }	
    
  //*****************************************************************************************
    //*	Name		    : isWebElementEnabled
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public boolean isWebElementEnabled(WebElement webElement) throws InterruptedException {
    	//Check if the WebElement is Enabled
        boolean bIsEnabled = webElement.isEnabled();
        String state = bIsEnabled ? "enabled" : "disabled";
        String strDesc = webElement.toString();

        return  bIsEnabled;
    }	
    

    //*****************************************************************************************
    //*	Name		    : isWebElementSelected
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public boolean isWebElementSelected(String strDesc) {
        //Get WebElement
        WebElement webElement = getElement(strDesc);
        return isWebElementSelected(webElement);
    }

    //*****************************************************************************************
    //*	Name		    : isWebElementSelected
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public boolean isWebElementSelected(WebElement webElement){
        boolean bIsSelected = webElement.isSelected();
        String state = bIsSelected ? "selected" : "unselected";
        String strDesc = webElement.toString();

        return  bIsSelected;
    }

    //*****************************************************************************************
    //*	Name		    : waitForWebElementToBeVisibleAndEnabled
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers waitForWebElementToBeVisibleAndEnabled(WebElement element,int seconds){

        while((!element.isDisplayed() || !element.isEnabled()) && seconds>0){
            try{
                Thread.sleep(seconds*1000);
                seconds --;
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        if(seconds == 0)
            throw(new ElementNotVisibleException("Wrapper method waitForWebElementToBeVisibleAndEnabled() : Element with desc " + element.toString() + "is either not visible or is not enabled"));

        return this;
    }

    //*****************************************************************************************
    //*	Name		    : click
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers click(String strDesc)
    {
        //Initialize
        WebElement webElement = getElement(strDesc);
        return click(webElement);
    }
    
  //*****************************************************************************************
    //*	Name		    : click
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers click(WebElement objClick)
    {
        waitForWebElementToBeVisibleAndEnabled(objClick,5);
        objClick.click();
        return this;
    }	

	//*****************************************************************************************
    //*	Name		    : enterText
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers enterText(String strDesc, String strText)
    {
        WebElement webElement = getElement(strDesc);
        return enterText(webElement,strText);
    }	
    
    //*****************************************************************************************
    //*	Name		    : enterText
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers enterText(WebElement objEdit, String strText)
    {
        waitForWebElementToBeVisibleAndEnabled(objEdit,5);
        objEdit.clear();
        objEdit.sendKeys(strText);
        return this;
    }	


    //*****************************************************************************************
    //*	Name		    : selectOptionFromList
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers selectOptionFromList(String strDesc, String strText)
    {
        WebElement webElement = getElement(strDesc);
        return selectOptionFromList(webElement,strText);
    }
    
    //*****************************************************************************************
    //*	Name		    : selectOptionFromList
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers selectOptionFromList(WebElement objSelect, String strText)
    {
    	String strDesc = objSelect.toString();

        //Check if the object is enabled, if yes click the same
        if (objSelect.isDisplayed() && objSelect.isEnabled()){
            //Set Select Element and select required value by text
            try{
                Select select = new Select(objSelect);
                select.selectByVisibleText(strText);
            }
            catch(WebDriverException ex){
                
                throw(ex);
            }
        }
        else{
            throw(new ElementNotVisibleException("Wrapper method selectOptionFromList() : Element with description " + strDesc + " is either not visible or is not enabled"));
        }

        return this;
    }
    

    
    //*****************************************************************************************
    //*	Name		    : checkCheckBox
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers checkCheckBox(String strDesc)
    {
        //Initialize
        WebElement webElement = getElement(strDesc);
        return checkCheckBox(webElement);
    }
    
  //*****************************************************************************************
    //*	Name		    : checkCheckBox
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers checkCheckBox(WebElement objChkBox)
    {
    	String strDesc = objChkBox.toString();

        //Check if the object is enabled, if yes click the same
        if (objChkBox.isDisplayed() && objChkBox.isEnabled()){
            //Check state of check box
            boolean isChecked = objChkBox.isSelected();

            //Check if Not Checked
            if(isChecked == false) objChkBox.click();
        }
        else{
            throw(new ElementNotVisibleException("Wrapper method checkCheckBox() : Element with description " + strDesc + " is either not visible or is not enabled"));
        }
        
        return this;
    }
    
    //*****************************************************************************************
    //*	Name		    : uncheckCheckBox
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers uncheckCheckBox(String strDesc)
    {
        //Initialize
        WebElement webElement = getElement(strDesc);
        return uncheckCheckBox(webElement);
    }	
    
    //*****************************************************************************************
    //*	Name		    : uncheckCheckBox
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers uncheckCheckBox(WebElement objChkBox)
    {
    	String strDesc = objChkBox.toString();

        //Check if the object is enabled, if yes click the same
        if (objChkBox.isDisplayed() && objChkBox.isEnabled()){
            //Check state of check box
            boolean isChecked = objChkBox.isSelected();

            //Check if Checked
            if(isChecked == true) objChkBox.click();
        }
        else{
            throw(new ElementNotVisibleException("Wrapper method checkCheckBox() : Element with description " + strDesc + " is either not visible or is not enabled"));
        }

        return this;
    }
	
	//*****************************************************************************************
    //*	Name		    : getCurrentBrowser
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
	public String getCurrentBrowser()
	{
		try
		{
			Capabilities DC = ((RemoteWebDriver)driver).getCapabilities();
			return DC.getBrowserName();
		}
		catch(WebDriverException e)
		{
			throw(e);
		}
	}

    //*****************************************************************************************
    //*	Name		    : rotateDeviceScreen
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers rotateDeviceScreen(String Orientation) throws InterruptedException {

        String strOrientation = "";
        ScreenOrientation iOrientation;

        try{
            if (Orientation.equalsIgnoreCase("L")){
                ((AppiumDriver)driver).rotate(ScreenOrientation.LANDSCAPE);
                iOrientation = ScreenOrientation.LANDSCAPE;
                strOrientation = "Landscape";
            }
            else {
                ((AppiumDriver)driver).rotate(ScreenOrientation.PORTRAIT);
                iOrientation = ScreenOrientation.PORTRAIT;
                strOrientation = "Portrait";
            }

            //wait till orientation change
            Thread.sleep(1000);
        }
        catch(WebDriverException ex){
            throw(ex);
        }

        return this;
    }

    //*****************************************************************************************
    //*	Name		    : setGeoLocation
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers setGeoLocation(String lat, String lon){
        //js
        String Script = "window.navigator.geolocation.getCurrentPosition =  function(success){var position = {'coords' : {'latitude': '" + lat + "', 'longitude': '" + lon + "'}}; success(position);}";

        //Update geolocation
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Object[] args = {null};
        js.executeScript(Script, args);

        return this;
    }

    //*****************************************************************************************
    //*	Name		    : getPageTitle
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public String getTitle(){
        return driver.getTitle();
    }

    //*****************************************************************************************
    //*	Name		    : getCurrentAndroidActivity
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public String getCurrentAndroidActivity(){
        return ((AndroidDriver)driver).currentActivity();
    }

    //*****************************************************************************************
    //*	Name		    : maximizeWindow
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers maximizeWindow()
    {
        try{
            driver.manage().window().maximize();
        }
        catch(WebDriverException e){
            throw(e);
        }

        return this;
    }

    //*****************************************************************************************
    //*	Name		    : switchToWindowWithName
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
	public Wrappers switchToWindowWithName() throws Exception {
		try
		{
			//driver.switchTo().window(strWindowName);
			//Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		}
		catch(Exception e)
		{
			throw(e);
		}
		
		return this;
	}

    //*****************************************************************************************
    //*	Name		    : waitForAndroidActivity
    //*	Author		    : Aniket Gadre
    //*****************************************************************************************
    public Wrappers waitForAndroidActivity(String expectedActivity,int sec)
    {
    	int i = 0;
    	String actualActivity="";
    	
    	//Loop for activity
    	while(i<sec)
    	{

    		actualActivity = ((AndroidDriver)driver).currentActivity();
    		if(actualActivity.equals(expectedActivity)){
                
                return this;
            }
    		
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            //increment
    		i++;
    	}
        
    	throw(new TimeoutException("Timeout occured while waiting for Android Activity " + expectedActivity + " Current Activity is " + actualActivity));
    }

    public void takeScreenshot(String SSName)
    {
        try
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
            FileUtils.copyFile(scrFile, new File(screenshotDirectory + "/" + SSName + ".png"));

        } catch (IOException io) {
            io.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
