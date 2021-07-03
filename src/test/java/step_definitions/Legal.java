package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.junit.Assert;
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

public class Legal {
    public WebDriver driver;
    WebDriverWait wait;
    public Legal()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver2.exe");
        driver = new ChromeDriver();
    }

    @Given("open websitelegal to check")
    public void open_websitelegal_to_check() throws InterruptedException{

        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.get("http://103.226.139.66:8080/en/");
    }
    @When("sign legal")
    public void sign_legal() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"hide_xs\"]")).click();
        driver.findElement(By.id("email")).sendKeys("ariehutaju@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("arie123");
        driver.findElement(By.id("SubmitLogin")).click();//add to chart
        driver.findElement(By.xpath("//*[@class=\"icon-chevron-left\"]")).click();
        Thread.sleep(1000);
    }

    @Then("click legal")
    public void click_legal() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"header\"]//*[@class=\"nav_toggle\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"menu_cont\"]//a[@href=\"http://103.226.139.66:8080/en/content/2-legal-notice\"]\n")).click();
        Thread.sleep(1000);
        String bodyText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/h2\n")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Legal"));
        Thread.sleep(1000);
        driver.quit();
    }
}