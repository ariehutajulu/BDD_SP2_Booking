package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
//import static org.testng.Assert.assertEquals;

public class ClickMenu3 {
    public WebDriver driver;
    WebDriverWait wait;
    public ClickMenu3()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver2.exe");
        driver = new ChromeDriver();
    }

    @Given("open website to check")
    public void open_website_to_check() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.get("http://103.226.139.66:8080/en/");
    }
    @When("sign in")
    public void sign_in() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"hide_xs\"]")).click();
        driver.findElement(By.id("email")).sendKeys("ariehutaju@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("arie123");

    }

    @Then("click menu")
    public void click_menu() throws InterruptedException {
        driver.findElement(By.id("SubmitLogin")).click();//add to chart
        driver.findElement(By.xpath("//*[@class=\"icon-chevron-left\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"header\"]//*[@class=\"nav_toggle\"]")).click();
        driver.quit();
    }
}
