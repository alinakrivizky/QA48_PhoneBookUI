package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phonebook.models.User;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void loginPositiveTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSingOutPresent());
    }

    @Test(enabled = false)
    public void loginNegativeTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setPassword("Va11hall@"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }

}
