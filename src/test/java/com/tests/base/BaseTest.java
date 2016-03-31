package com.tests.base;

import com.framework.core.Driver;
import com.framework.core.Wrappers;
import com.framework.handlers.XMLHandler;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by gadrea on 11/6/2015.
 */
public class BaseTest {

    private String environment;
    public String className;
    public String browser;
    public Driver asapDriver;
    public WebDriver driver = null;
    public Wrappers doAction;

    public void beforeClass() throws IOException {
        System.out.println(className);
        setEnvironment();
        asapDriver = new Driver();
    }

    public void beforeMethod(Method method){
        String testName = method.getName();
        System.out.println("Before Method for test " + testName);
    }

    public void afterMethod(Method method) {
        String testName = method.getName();
        System.out.println("After Method" + testName);
    }

    public void afterClass(){
        System.out.println("After Class " + className);
        
        if(driver != null)
            driver.quit();
    }

    void setEnvironment(){

        InputStream inputStream = this.getClass().getResourceAsStream("/executionConfig.xml");
        XMLHandler xmlHandler = new XMLHandler(inputStream);

        environment = xmlHandler.getElementsByTagName("environment").get(0).getTextContent();
        System.setProperty("executionEnv",environment);
    }

    public String getEnvironment(){
        return environment;
    }

}
