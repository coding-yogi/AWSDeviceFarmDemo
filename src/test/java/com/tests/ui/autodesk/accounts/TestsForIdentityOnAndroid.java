package com.tests.ui.autodesk.accounts;

import com.tests.base.BaseAppiumAndroidTest;
import com.ui.pageobjects.autodesk.accounts.LaunchApplication;
import com.ui.pageobjects.autodesk.accounts.LoginPage;
import com.ui.pageobjects.autodesk.accounts.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/**
 * Created by Aniket on 6/29/2015.
 */
public class TestsForIdentityOnAndroid extends BaseAppiumAndroidTest{

    @BeforeClass
    public void beforeClass() throws IOException {
        String[] strClassNameArray = this.getClass().getName().split("\\.");
        className = strClassNameArray[strClassNameArray.length-1];
        super.beforeClass();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        super.beforeMethod(method);
        //Initiate WebDriver
        if(driver==null){
            try{
                setAppiumChromeDriver("AWS Device", "http://127.0.0.1:4723/wd/hub", null);
            }
            catch(UnknownHostException e){
                System.out.print("Exception " + e);
            }
            catch(MalformedURLException e){
                System.out.print("Exception " + e);
            }
        }
    }

    @Test
    public void testValidLogin(){

        LaunchApplication app = new LaunchApplication(driver);
        LoginPage loginPage = app.launchIdentityApplication();
        loginPage.enterLoginCredentials("aniket@autodesk","Jaguar21");
        ProfilePage profilePage = loginPage.clickSignIn();
        Assert.assertTrue(profilePage.shouldHaveMyProfileTab(), "Assert Profile page has Profile Tab");
    }

    @AfterMethod
    public void afterMethod(Method method){
        super.afterMethod(method);
    }

    @AfterClass
    public void afterClass(){
        super.afterClass();
    }


}
