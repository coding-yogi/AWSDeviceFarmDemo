package com.ui.pageobjects.autodesk.accounts;

import com.framework.core.BasePage;
import com.framework.core.Wrappers;
import org.openqa.selenium.WebDriver;

/**
 * Created by gadrea on 4/25/2016.
 */
public class LandingPage extends BasePage {

    public static final String pageTitle = "Autodesk";

    //Page UI Objects
    private final String btnCreateAccount = "id:=register_btn";
    private final String btnSignIn = "id:=signin_btn";


    //Define the constructor
    public LandingPage(WebDriver GDriver)
    {
        driver = GDriver;
        objWrapper = new Wrappers(driver);
    }

    public UsernamePage clickSignIn(){
        objWrapper.click(btnSignIn);
        return new UsernamePage(driver);
    }
}
