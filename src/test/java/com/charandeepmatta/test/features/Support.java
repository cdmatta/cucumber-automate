package com.charandeepmatta.test.features;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebDriver;

import cuke4duke.annotation.After;

public class Support {
    private static WebDriver browser;
    private static Constructor<WebDriver> driverConstructor = getDriverConstructor();

    public Support() {
        browser = getWebDriver();
    }

    public void open(final String address) {
        browser.navigate().to(address);
    }

    @SuppressWarnings("unchecked")
    private static Constructor<WebDriver> getDriverConstructor() {
        String driverName = System.getProperty("webdriver.impl", "org.openqa.selenium.firefox.FirefoxDriver");
        try {
            return (Constructor<WebDriver>) Thread.currentThread().getContextClassLoader().loadClass(driverName).getConstructor();
        } catch (Throwable problem) {
            problem.printStackTrace();
            throw new RuntimeException("Couldn't load " + driverName, problem);
        }
    }

    public WebDriver getWebDriver() {
        try {
            if (browser == null) {
                browser = driverConstructor.newInstance();
            }
            return browser;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void closeBrowser() {
        if (browser != null) {
            browser.close();
            browser.quit();
        }
    }
}
