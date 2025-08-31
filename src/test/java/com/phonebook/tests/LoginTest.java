package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginPositiveTest(){

        clickOnLoginLink();
        fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());
    }

    @Test
    public void loginNegativeTest(){

        clickOnLoginLink();
        fillRegisterForm(new User().setPassword("Va11hall@"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());
    }

}
