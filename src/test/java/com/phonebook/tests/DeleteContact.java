package com.phonebook.tests;

import data.ContactData;
import data.UserData;
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
            app.getUser().fillRegisterForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));

            app.getUser().clickOnLoginButton();
        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME)
                .setLastName(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
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


