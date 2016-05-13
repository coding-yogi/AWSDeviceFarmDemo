package com.ui.pageobjects.autodesk.accounts;

import com.framework.core.BasePage;
import com.framework.core.Wrappers;
import org.openqa.selenium.WebDriver;

/**
 * Created by gadrea on 4/25/2016.
 */
public class PasswordPage extends BasePage{

    public static final String pageTitle = "Autodesk";

    //Page UI Objects
    private final String edtPassword = "id:=password";
    private final String btnSignIn = "id:=btnSubmit";
    private final String txtErrorForInvalidPassword = "xpath:=//span[text()='Email address / username and password do not match.']";

    //Define the constructor
    public PasswordPage(WebDriver GDriver)
    {
        driver = GDriver;
        objWrapper = new Wrappers(driver);
    }

    public PasswordPage enterPassword(String password){
        objWrapper.enterText(edtPassword,password);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        takeScreenshot("enterPassword");
        return this;
    }

    public <T extends BasePage> T clickSignIn(Class<T> clazz){
        objWrapper.click(btnSignIn);
        return getNewPageInstance(clazz);
    }

    public boolean IsInvalidPasswordErrorDisplayed() throws InterruptedException {
        takeScreenshot("Invalid Password");
        return objWrapper.isWebElementDisplayed(txtErrorForInvalidPassword);
    }
}
