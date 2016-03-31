package com.ui.pageobjects.autodesk.accounts;

import com.framework.core.Wrappers;
import org.openqa.selenium.WebDriver;

/**
 * Created by gadrea on 5/5/2015.
 */
public class ProfilePage {

    private WebDriver driver;
    private Wrappers objWrapper;

    public static final String pageTitle = "Autodesk - User Profile";
    String tbProfile = "classname:=profile";

    //Define the constructor
    public ProfilePage(WebDriver driver)
    {
        this.driver = driver;
        this.objWrapper = new Wrappers(driver);
    }

    public boolean shouldHaveMyProfileTab(){
        boolean isProfileTabPresent = objWrapper.isWebElementPresent(tbProfile);
        objWrapper.takeScreenshot("checkProfileTab");

        if(isProfileTabPresent){
            return true;
        }

        return false;
    }
}
