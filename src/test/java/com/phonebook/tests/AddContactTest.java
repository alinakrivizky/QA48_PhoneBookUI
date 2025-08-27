package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTest extends TestBase {
    //pre-condition login
    @BeforeMethod
    public void preconditions() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "al@gmail.com");
        type(By.name("password"), "Va11hall@");
        click(By.name("login"));
    }

    @Test
    public void addContactPositiveTest() {
        //click on link ADD
        click(By.cssSelector("[href='/add']"));

        //enter name
        type(By.cssSelector("input:nth-child(1)"), "Alan");
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"), "Krivizky");
        //enter phonenumber
        type(By.cssSelector("input:nth-child(3)"), "0567891221");
        //enter email
        type(By.cssSelector("input:nth-child(4)"), "AlanK@gmail.com");
        //enter address
        type(By.cssSelector("input:nth-child(5)"), "Rotshild 5,Herzliya");
        //enter description
        type(By.cssSelector("input:nth-child(6)"), "QA");
        //click on save button
        click(By.cssSelector(".add_main__1tbl_ button"));
        //verify contact is added
        Assert.assertTrue(isContactAdded("0567891221"));

    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h3"));
        for (WebElement contact : contacts) {
            if (contact.getText().contains(text))
                return true;
        }
        return false;
    }

    @AfterMethod
    public void postconditions() {
    click(By.cssSelector(".contact-item_card__2SOIM"));//.contact-item-detailed_card__50dTS//.contact-item_card__2SOIM
    click(By.xpath("//button[.='Remove']"));

    }
}

