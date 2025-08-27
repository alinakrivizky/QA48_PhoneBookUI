package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginPositiveTest(){
        //click on Login Link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "al@gmail.com");
        //Enter Password
        type(By.name("password"), "Va11hall@");
        //click on login button
        click(By.name("login"));
        Assert.assertTrue(isHomeComponentPresent(By.xpath("//button[.='Sign Out']")));
    }

}
