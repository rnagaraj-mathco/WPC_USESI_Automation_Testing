package core;

import DriverManager.DriverFactory;

public class BaseTest {
    public void startApplication() {
        DriverFactory.initializeDriver();
    }

    public void stopApplication() {
        DriverFactory.quitDriver();
    }
}
