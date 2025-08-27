package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{
    @Test
    public void isHomeComponentPresentTest() {
        //driver.findElement(By.xpath("//div[@class='navbar-component_nav__1X_4m']/h1"));
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        //System.out.println("Home Component "+isHomeComponentPresent());

        Assert.assertTrue(isHomeComponentPresent()); //assert is important for tests to not allow logic failures at all

    }
    public boolean isHomeComponentPresent() {
        return isHomeComponentPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }
}
