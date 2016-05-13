package com.tests.ui.autodesk.accounts;

import com.tests.base.BaseAppiumAndroidTest;
import com.ui.pageobjects.autodesk.accounts.*;
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

        ProfilePage profilePage = app.launchIdentityApplication()
                .clickSignIn()
                .enterUsername("aniket@autodesk")
                .clickNext(PasswordPage.class)
                .enterPassword("Jaguar21")
                .clickSignIn(ProfilePage.class);

        Assert.assertTrue(profilePage.shouldHaveMyProfileTab(), "Profile page does not have Profile Tab");
    }

    @Test
    public void testErrorForInvalidPassword() throws InterruptedException {
        LaunchApplication app = new LaunchApplication(driver);

        PasswordPage passwordPage = app.launchIdentityApplication()
                .clickSignIn()
                .enterUsername("aniket@autodesk")
                .clickNext(PasswordPage.class)
                .enterPassword("Jaguar212")
                .clickSignIn(PasswordPage.class);

        Assert.assertTrue(passwordPage.IsInvalidPasswordErrorDisplayed(), "Error not displayed");
    }

    @Test
    public void testErrorForInvalidUserName() throws InterruptedException {

        LaunchApplication app = new LaunchApplication(driver);

        UsernamePage usernamePage = app.launchIdentityApplication()
                .clickSignIn()
                .enterUsername("aniket123@autodesk")
                .clickNext(UsernamePage.class);

        Assert.assertTrue(usernamePage.IsInvalidUserNameErrorDisplayed(), "Error not displayed");
    }

    @AfterMethod
    public void afterMethod(Method method){
        super.afterMethod(method);
        if(driver != null)
            driver.quit();
        driver = null;
    }

    @AfterClass
    public void afterClass(){
        super.afterClass();
    }


}
