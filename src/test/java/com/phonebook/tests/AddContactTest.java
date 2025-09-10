package com.phonebook.tests;

import data.ContactData;
import data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import phonebook.models.Contact;
import phonebook.models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTest extends TestBase {
    //pre-condition login
    @BeforeMethod
    public void preconditions() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //String phone = "05" + (10000000 + (int)(Math.random() * 90000000));  // уникальный телефон
        // сохранили в переменную

        //click on link ADD
        app.getContact().clickOnAddButton();
        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME)
                .setLastName(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactAdded(ContactData.PHONE));

    }
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kann","kann12@gmail.com", "13234490545","Rehovot", "QA"});
        list.add(new Object[]{"Oliver", "Snickers","kann12@gmail.com", "354859374","Rehovot", "QA"});
        list.add(new Object[]{"Oliver", "Mars", "kann12@gmail.com", "4593442769","Rehovot", "QA"});
        return list.iterator();
    }
    @Test(dataProvider = "addNewContact")
    public void addContactPositiveFromProviderTest(String name, String lastName, String phone,
                                                   String email, String address, String description) {
        //String phone = "05" + (10000000 + (int)(Math.random() * 90000000));  // уникальный телефон
        // сохранили в переменную

        //click on link ADD
        app.getContact().clickOnAddButton();
        app.getContact().fillContactForm(new Contact().setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                        .setDescription(description));


        app.getContact().clickOnAddButton();
        app.getContact().clickOnSaveButton();

    }



    @AfterMethod
    public void postconditions() {
        app.getContact().deleteContact();

    }
}

