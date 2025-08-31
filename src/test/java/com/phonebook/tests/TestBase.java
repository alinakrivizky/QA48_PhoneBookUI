package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java. time.Duration;
import java.util.List;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isHomeComponentPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        if (text!=null) {


            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
       new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator))
               .click();
    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }

    public void clickOnRegisterButton() {
        click(By.name("registration"));
    }

    public void fillRegisterForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
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
        for (WebElement contact: contacts) {
            if (contact.getText().contains(text))
                return true;
        }
        return false;
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public void deleteContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));//.contact-item-detailed_card__50dTS
        click(By.xpath("//button[.='Remove']"));
    }
}


