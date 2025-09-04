package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import phonebook.models.User;

public class LoginTest extends TestBase {
    @Test
    public void loginPositiveTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

    @Test
    public void loginNegativeTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setPassword("Va11hall@"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
