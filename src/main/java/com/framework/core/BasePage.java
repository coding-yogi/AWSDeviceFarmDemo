package com.framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadrea on 4/25/2016.
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected Wrappers objWrapper;

    //Common Objects across Pages
    private final String txtErrors = "xpath:=//span[contains(@class,'field-validation-error')]/span";

    protected void takeScreenshot(String screenshotName){
        objWrapper.takeScreenshot(screenshotName);
    }

    //*****************************************************************************************
    //*    Name        	: getErrorMessages
    //*    Author       : Aniket Gadre
    //*****************************************************************************************
    public List<String> getErrorMessages()
    {
        List<String> lstErrors = new ArrayList<String>();
        List<WebElement> elementErrors = objWrapper.getElements(txtErrors);
        for(WebElement elemError : elementErrors){
            lstErrors.add(elemError.getText());
        }

        return lstErrors;
    }

    //*****************************************************************************************
    //*    Name        	: shouldDisplayError
    //*    Author       : Aniket Gadre
    //*****************************************************************************************
    public boolean shouldDisplayError(String errorMessage)
    {
        takeScreenshot("Error");
        List<String> lstErrorMessages = getErrorMessages();
        for(String strErrorMessage : lstErrorMessages){
            if(strErrorMessage.equals(errorMessage)){
                return true;
            }
        }

        return false;
    }

    public <T extends BasePage> T getNewPageInstance(Class<T> clazz){
        //new Class<?>[]{driver.getClass()}
        try{
            return clazz.getConstructor(WebDriver.class).newInstance(new Object[]{driver});
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
