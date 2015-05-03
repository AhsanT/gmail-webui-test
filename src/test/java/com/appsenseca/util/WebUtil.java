package com.appsenseca.util;

import com.appsenseca.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by appken on 15-05-03.
 */
public class WebUtil {

    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }
}
