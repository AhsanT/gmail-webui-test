import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSignInTest {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void gmailLoginShouldBeSuccessful() {
        //1. Go to Gmail website
        driver.get("http://gmail.com");
        //2. Fill in username
        WebElement usernameTextbox = driver.findElement(By.id("Email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("udemyken@gmail.com");
        //3. Fill in password
        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys("udemyken123");
        //4. click sign in
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();
        //5. verify user did sign in
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);
        //6. sign out
        WebElement profileButton = driver.findElement(By.cssSelector("span[class='gb_da gbii']"));
        profileButton.click();

        WebElement signOutLinkage = driver.findElement(By.id("gb_71"));
        signOutLinkage.click();

        //7. verified user did sign out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
        Assert.assertTrue("signIn button should exist", driver.findElements(By.id("signIn")).size() > 0);
    }

    @Test
    public void gmailSendAndReceiveEmailTest() {
        // 1. Click sign in
        //1. Go to Gmail website
        driver.get("http://gmail.com");
        //2. Fill in username
        WebElement usernameTextbox = driver.findElement(By.id("Email"));
        usernameTextbox.clear();
        usernameTextbox.sendKeys("udemyken@gmail.com");
        //3. Fill in password
        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys("udemyken123");
        //4. click sign in
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();
        //5. verify user did sign in
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);
        // 2. Click Compose
        WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        composeButton.click();
        // 3. Fill in recipient
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
        WebElement toTextArea = driver.findElement(By.cssSelector("textarea[name='to']"));
        toTextArea.clear();
        toTextArea.sendKeys("udemyken@gmail.com");
        // 4. Fill in subject
        WebElement subjectTextArea = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        final String subject = "Gmail Send Email Test";
        subjectTextArea.clear();
        subjectTextArea.sendKeys(subject);
        // 5. Fill in email body
        WebElement bodyTextArea = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        final String body = "Hello Testers Good Morning";
        bodyTextArea.clear();
        bodyTextArea.sendKeys(body);
        // 6. Click Send
        WebElement sendButton = driver.findElement(By.cssSelector("div[aria-label*=\"Send\"]"));
        sendButton.click();
        // 7. Click Inbox again
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Inbox (1)")));
        WebElement inboxLinkage = driver.findElement(By.linkText("Inbox (1)"));
        inboxLinkage.click();
        // 8. Click email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
        WebElement newEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
        newEmail.click();
        // 9. Verify the email subject and email body is correct
        WebElement subjectArea = driver.findElement(By.cssSelector("h2[class='hP']"));
        Assert.assertEquals("Email Subject Text shoudld be the same", subject, subjectArea.getText());
        WebElement bodyArea = driver.findElement(By.cssSelector("div[class='nH aHU'] div[dir='ltr']"));
        Assert.assertEquals("Email Body Text shoudld be the same", body, bodyArea.getText());
        // 10. Sign out
        WebElement profileButton = driver.findElement(By.cssSelector("span[class='gb_da gbii']"));
        profileButton.click();

        WebElement signOutLinkage = driver.findElement(By.id("gb_71"));
        signOutLinkage.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
