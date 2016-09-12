package mainPack;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class AddNewClient {
    WebDriver driver = new ChromeDriver();
    Logger log = Logger.getLogger(getClass());
    String name;
    String telephone;
    String email;
    String password;
    String repeatPassword;

    public AddNewClient(String clientName, String clientTelephone, String clientEmail,
                        String clientPassword, String clientRepeatPassword) {
        this.name = clientName;
        this.telephone = clientTelephone;
        this.email = clientEmail;
        this.password = clientPassword;
        this.repeatPassword = clientRepeatPassword;}

        @Parameterized.Parameters
        public static Collection testData1() {
            return Arrays.asList(new Object[][]{
                    {"testName","Механика"},
            });
        }

    @Test

    public void openBrowserAndLoginPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        log.info("Browser and Login page were opened");

        driver.get("http://telemart.ua/registration/");
        log.info("Url was opened");

        Assert.assertTrue("Assert works", driver.findElement(By.id("password1")).isDisplayed());

        driver.quit();
        log.info("Driver was closed");
    }


}
