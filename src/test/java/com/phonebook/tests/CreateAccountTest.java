package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
    //int i=(int)(System.currentTimeMillis()/1000)%3600;
        clickOnLoginLink();
        fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        clickOnRegisterButton();
        Assert.assertTrue(isAlertDisplayed());


    }

    @Test
    public void newExistedUserRegistrationNegativeTest() {
        clickOnLoginLink();
        fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        clickOnRegisterButton();
        Assert.assertTrue(isAlertDisplayed());
    }

}




