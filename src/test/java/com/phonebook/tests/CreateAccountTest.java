package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    @Test
    public void newUserRegistrationPositiveTest() {
        //click on Login Link
        driver.findElement(By.cssSelector("[href='/login']")).click();
        //enter Email
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("al@gmail.com");
        //Enter Password
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("Va11hall@");
        //click on Registration Button
        driver.findElement(By.name("registration")).click();
        //verify SignOut is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

}



