package com.phonebook.tests; // пакет тестов, как у учителя

import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName())); // создаём объект

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();  // инициализируем драйвер и helper'ы
    }

    //@AfterMethod
    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();  // закрываем браузер
    }
}
