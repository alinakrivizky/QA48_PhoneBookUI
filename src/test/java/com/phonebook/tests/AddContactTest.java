package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {
    //pre-condition login
    @BeforeMethod
    public void preconditions() {
        clickOnLoginLink();
        fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        String phone = "05" + (10000000 + (int)(Math.random() * 90000000));  // уникальный телефон
        // сохранили в переменную

        //click on link ADD
        clickOnAddButton();
        fillContactForm(new Contact().setName("Alan")
                .setLastName("Krivizky")
                .setPhone(phone)
                .setEmail("al2012@gmail.com")
                        .setAddress("Rotshild 4, Herzliya")
                .setDescription("QA"));
        clickOnSaveButton();

        Assert.assertTrue(isContactAdded(phone));

    }

    @AfterMethod
    public void postconditions() {
        deleteContact();

    }
}

