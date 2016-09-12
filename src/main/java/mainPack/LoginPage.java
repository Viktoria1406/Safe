package mainPack;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    Logger log;

    public LoginPage loginPage;
    @FindBy(id = "customer_firstname")
    WebElement inputLogin;

    @FindBy(id = "other")
    WebElement inputTelephone;

    @FindBy(id = "email_reg")
    WebElement inputEmail;

    @FindBy(id = "passwd")
    WebElement inputPassword;

    @FindBy(id = "passwd_confirm")
    WebElement inputRepeatPassword;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, this);
    }
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://telemart.ua/registration/");
            log.info("Browser and Login page were opened");
        } catch (Exception e) {
            log.error("Can't work with browser or login page");
            // Assert.fail("Can't work with browser or login page" + e);
        }
    }
    public void closeLoginPageAndBrowser() {
        driver.quit();
        log.info("Browser ans=d PageLogin were closed");
    }
}
