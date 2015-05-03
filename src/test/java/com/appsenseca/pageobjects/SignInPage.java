package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.print.PageFormat;

/**
 * Created by appken on 15-05-03.
 */
public class SignInPage {

    public void fillInUsername(WebDriver driver, String s) {
        WebElement usernameTextbox = driver.findElement(By.id("Email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("udemyken@gmail.com");
    }

    public void fillInPassword(WebDriver driver, String s) {
        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(s);
    }

    public EmailHomePage clickSignIn(WebDriver driver) {
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));

        return PageFactory.initElements(driver, EmailHomePage.class);
    }

    public boolean isSignInButtonExist(WebDriver driver) {
        return driver.findElements(By.id("signIn")).size() > 0;
    }
}
