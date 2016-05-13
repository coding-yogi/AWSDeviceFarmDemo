package com.ui.pageobjects.autodesk.accounts;

import com.framework.core.BasePage;
import com.framework.core.Wrappers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by gadrea on 4/2/2015.
 */
public class UsernamePage extends BasePage{

    public static final String pageTitle = "Autodesk - Sign In";

    //Page UI Objects
    private final String edtUserName = "id:=userName";
    private final String btnNext = "id:=verify_user_btn";
    private final String txtInvalidUserName = "xpath:=//div[contains(text(),'This email or username is not recognized')]";


    //Define the constructor
    public UsernamePage(WebDriver GDriver)
    {
        driver = GDriver;
        objWrapper = new Wrappers(driver);
    }

    public UsernamePage enterUsername(String username)
    {
        objWrapper.enterText(edtUserName, username);
        takeScreenshot("enterUserName");
        return this;
    }

    public <T extends BasePage> T clickNext(Class<T> clazz)
    {
        WebElement elemNext = objWrapper.getElement(btnNext);
        objWrapper.click(elemNext);
        int iCnt = 1;
        do{
            try{
                Thread.sleep(100);
                iCnt++;
            }catch(Exception e){
            }
        }while(elemNext.getText().equalsIgnoreCase("Verifying...") || iCnt<30);
        return getNewPageInstance(clazz);
    }

    public boolean IsInvalidUserNameErrorDisplayed() throws InterruptedException {
        takeScreenshot("InvalidUserName");
        return objWrapper.isWebElementDisplayed(txtInvalidUserName);
    }
}
