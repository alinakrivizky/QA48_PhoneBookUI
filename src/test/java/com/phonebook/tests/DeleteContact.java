package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase {
    @BeforeMethod
    public void preconditions() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "al@gmail.com");
        type(By.name("password"), "Va11hall@");
        click(By.name("login"));


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
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContact();
                //click on the cart
       click(By.cssSelector(".contact-item_card__2SOIM"));//.contact-item-detailed_card__50dTS
        click(By.xpath("//button[.='Remove']"));

        int sizeAfter = sizeOfContact();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }
    public int sizeOfContact(){
        if (isElementPresent (By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }
    return 0;
}
}

