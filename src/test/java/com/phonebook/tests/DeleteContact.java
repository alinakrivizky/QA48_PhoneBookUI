package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phonebook.models.Contact;
import phonebook.models.User;

public class DeleteContact extends TestBase {
    @BeforeMethod
    public void preconditions() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        app.getUser().clickOnLoginButton();

        String phone = "0567891221";  // сохраняем телефон для проверки и удаления

        app.getContact().clickOnAddButton();
        app.getContact().fillContactForm(
                new Contact().setName("Alan")
                        .setLastName("Krivizky")
                        .setPhone(phone)
                        .setEmail("al2012@gmail.com")
                        .setAddress("Rotshild 4, Herzliya")
                        .setDescription("QA"));

        app.getContact().clickOnSaveButton();

        // Проверяем, что контакт добавлен
        Assert.assertTrue(app.getContact().isContactAdded(phone));
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = app.getContact().sizeOfContact();
                //click on the cart
        app.getContact().deleteContact();

        int sizeAfter = app.getContact().sizeOfContact();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}

