package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContact extends TestBase {
    @BeforeMethod
    public void preconditions() {
        clickOnLoginLink();
        fillRegisterForm(new User().setEmail("al@gmail.com").setPassword("Va11hall@"));
        clickOnLoginButton();

        String phone = "0567891221";  // сохраняем телефон для проверки и удаления

        clickOnAddButton();
        fillContactForm(
                new Contact().setName("Alan")
                        .setLastName("Krivizky")
                        .setPhone(phone)
                        .setEmail("al2012@gmail.com")
                        .setAddress("Rotshild 4, Herzliya")
                        .setDescription("QA"));

        clickOnSaveButton();

        // Проверяем, что контакт добавлен
        Assert.assertTrue(isContactAdded(phone));
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContact();
                //click on the cart
        deleteContact();

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

