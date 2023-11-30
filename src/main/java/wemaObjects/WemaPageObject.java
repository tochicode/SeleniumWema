package wemaObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class WemaPageObject {
   WebDriver driver;

    WebDriverWait wait;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void allUserLogin(String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Selector.usernameField)));
        driver.findElement(By.cssSelector(Selector.usernameField)).sendKeys(username);
        driver.findElement(By.cssSelector(Selector.passwordField)).sendKeys(Selector.password);
        driver.findElement(By.cssSelector(Selector.loginbutton)).click();
    }

    public void logoutUser(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id = \"menu_button_container\"]")));
        driver.findElement(By.cssSelector("[id = \"react-burger-menu-btn\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class = \"bm-menu\"]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class = \"bm-item-list\"]")));
        driver.findElement(By.cssSelector("[id = \"logout_sidebar_link\"]")).click();
    }

    public void teardown(){
        driver.close();
    }


}
