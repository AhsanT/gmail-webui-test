package com.appsenseca.pageobjects;

import com.appsenseca.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by appken on 15-05-03.
 */
public class EmailHomePage {
    public SignInPage signOut(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("span[class='gb_da gbii']"));

        WebUtil.click(driver, By.id("gb_71"));

        WebUtil.waitForElementVisible(driver, By.id("signIn"));

        return PageFactory.initElements(driver, SignInPage.class);
    }


    public boolean isInboxExist(WebDriver driver) {
        return WebUtil.isElementExist(driver, By.partialLinkText("Inbox"));
    }

    public void clickComposeButton(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[role='button'][gh='cm']"));
    }

    public void fillInRecipient(WebDriver driver, String s) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("textarea[name='to']"));

        WebUtil.clearAndSendKeys(driver, By.cssSelector("textarea[name='to']"), "udemyken@gmail.com");
    }

    public void fillInSubject(WebDriver driver, String subject) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("input[name='subjectbox']"), subject);
    }

    public void fillInEmailBody(WebDriver driver, String body) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("div[aria-label='Message Body']"), body);
    }

    public void clickSendEmail(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[aria-label*='Send']"));
    }

    public void clickInboxWithNewEmail(WebDriver driver, String s) {
        WebUtil.waitForElementVisible(driver, By.linkText("Inbox (1)"));

        WebUtil.click(driver, By.linkText("Inbox (1)"));
    }


    public EmailViewPage clickNewEmail(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("div[class='y6'] span[id] b"));

        WebUtil.click(driver, By.cssSelector("div[class='y6'] span[id] b"));

        return PageFactory.initElements(driver, EmailViewPage.class);
    }
}
