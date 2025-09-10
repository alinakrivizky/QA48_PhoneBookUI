package com.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    // Метод проверяет наличие Home компонента
    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }


    public void clickOnHomelink() {
        click(By.cssSelector("[href='/home']"));
    }
}

