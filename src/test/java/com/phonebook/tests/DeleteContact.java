package com.phonebook.tests;

import org. testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phonebook.models.Contact;
import phonebook.models.User;

public class DeleteContact extends TestBase {
    @BeforeMethod
    public void preconditions() {
            if(!app.getUser().isLoginLinkPresent()){
                app.getUser().clickOnSignOutButton();
            }

            app.getUser().clickOnLoginLink();
            app.getUser().fillRegisterForm(new User()
                    .setEmail("al@gmail.com")
                    .setPassword("Va11hall@"));

            app.getUser().clickOnLoginButton();
            app.getContact().fillContactForm(new Contact().setName("Alan")
                    .setLastName("Krivizky")
                    .setPhone("0546738294")
                    .setEmail("al2012@gmail.com")
                    .setAddress("Rotshild 4, Herzliya")
                    .setDescription("QA"));
            app.getContact().clickOnSaveButton();
        }
        @Test
        public void deleteContactTest () {
            int sizeBefore = app.getContact().sizeOfContact();
            app.getContact().deleteContact();
            app.getContact().pause(1000);
            int sizeAfter = app.getContact().sizeOfContact();
            Assert.assertEquals(sizeAfter, sizeBefore - 1);

        }

    }


