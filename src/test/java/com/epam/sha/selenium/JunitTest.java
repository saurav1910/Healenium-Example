package com.epam.sha.selenium;
import com.epam.healenium.SelfHealingDriver;
import config.BackendContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.epam.healenium.SelfHealingDriver.create;
//@Testcontainers
public class JunitTest {
    // @Container
    //   public static BackendContainer container = BackendContainer.getInstance();

    By emailButton = By.xpath("//input[@name='username']");

    SelfHealingDriver driver ;

    @BeforeEach
    public void doingBefore() {


    }

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\dc-user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver delegate = new ChromeDriver();
        System.out.println("here");

        driver = create(delegate);
        PageFactory.initElements(driver, this);
        driver.get("http://localhost:8082/");
        driver.manage().window().maximize();
        try {
            Thread.sleep(3);
        }
        catch (Exception e){

        }

        WebElement email = driver.findElement(emailButton);
        email.sendKeys("saurabh");
        try {
            Thread.sleep(100);
        }
        catch (Exception e){

        }
        driver.quit();
    }



}
