package com.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import phonebook.models.Contact;

import java.util.List;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddButton() {
        click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        //enter name
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        //enter lastname
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        //enter phonenumber
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        //enter email
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        //enter address
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        //enter description
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());

    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_main__1tbl_ button"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h3"));
        for (WebElement contact : contacts) {
            if (contact.getText().contains(text))
                return true;
        }
        return false;
    }

    public void deleteContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));//.contact-item-detailed_card__50dTS
        click(By.xpath("//button[.='Remove']"));
    }

    public int sizeOfContact() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
