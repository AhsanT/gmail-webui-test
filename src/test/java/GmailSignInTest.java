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

    @After
    public void tearDown() {
        driver.quit();
    }
}
