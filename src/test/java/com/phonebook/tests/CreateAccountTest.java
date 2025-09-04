package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import phonebook.models.User;

public class CreateAccountTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
    //int i=(int)(System.currentTimeMillis()/1000)%3600;
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());


    }

    @Test
    public void newExistedUserRegistrationNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        app.getUser().clickOnRegisterButton();
       softAssert.assertTrue(app.getUser().isAlertDisplayed());
       softAssert.assertTrue(app.getUser().isErrorMessagePresent());
       softAssert.assertAll();
    }

}




