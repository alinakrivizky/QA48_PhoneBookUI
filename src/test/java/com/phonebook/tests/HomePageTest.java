package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }


    @Test
    public void isHomeComponentPresentTest() {

        //driver.findElement(By.xpath("//div[@class='navbar-component_nav__1X_4m']/h1"));
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        //System.out.println("Home Component "+isHomeComponentPresent());
        //assert is important for tests to not allow logic failures at all
        Assert.assertTrue(app.getHome().isHomeComponentPresent());

    }
}

