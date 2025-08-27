package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
    int i=(int)(System.currentTimeMillis()/1000)%3600;
        //click on Login Link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "al@gmail.com");
        //Enter Password
        type(By.name("password"), "Va11hall@");
        //click on Registration Button
        click(By.name("registration"));
        //verify SignOut is displayed
        Assert.assertTrue(isHomeComponentPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test
    public void newExistedUserRegistrationNegativeTest() {
        //click on Login Link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "al@gmail.com");
        //Enter Password
        type(By.name("password"), "Va11hall@");
        //click on Registration Button
        click(By.name("registration"));
        //verify SignOut is displayed
        Assert.assertTrue(isAlertDisplayed());
    }

}




