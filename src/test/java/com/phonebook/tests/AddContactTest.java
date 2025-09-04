package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phonebook.models.Contact;
import phonebook.models.User;

public class AddContactTest extends TestBase {
    //pre-condition login
    @BeforeMethod
    public void preconditions() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        String phone = "05" + (10000000 + (int)(Math.random() * 90000000));  // уникальный телефон
        // сохранили в переменную

        //click on link ADD
        app.getContact().clickOnAddButton();
        app.getContact().fillContactForm(new Contact().setName("Alan")
                .setLastName("Krivizky")
                .setPhone(phone)
                .setEmail("al2012@gmail.com")
                        .setAddress("Rotshild 4, Herzliya")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactAdded(phone));

    }

    @AfterMethod
    public void postconditions() {
        app.getContact().deleteContact();

    }
}

