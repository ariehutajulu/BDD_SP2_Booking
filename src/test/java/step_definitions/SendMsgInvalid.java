package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
//import static org.testng.Assert.assertEquals;

public class SendMsgInvalid {
    public WebDriver driver;
    WebDriverWait wait;
    public SendMsgInvalid()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver2.exe");
        driver = new ChromeDriver();
    }

    @Given("open websitesendinvmsg to check")
    public void open_websitesendinvmsg_to_check() throws InterruptedException{

        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.get("http://103.226.139.66:8080/en/");
    }
    @When("sign sendinvmsg")
    public void sign_sendinvmsg() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"hide_xs\"]")).click();
        driver.findElement(By.id("email")).sendKeys("ariehutaju@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("arie123");
        driver.findElement(By.id("SubmitLogin")).click();//add to chart
        driver.findElement(By.xpath("//*[@class=\"icon-chevron-left\"]")).click();
        Thread.sleep(1000);
    }

    @Then("click sendinvmsg")
    public void click_sendinvmsg() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"header\"]//*[@class=\"nav_toggle\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"menu_cont\"]//a[@href=\"http://103.226.139.66:8080/en/contact-us\"]\n")).click();
        Thread.sleep(1000);
        String bodyText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/p[1]\n")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains("Contact Us"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]//*[@id=\"contact_type\"]\n")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@class=\"dropdown-menu contact_type_ul\"]//li[@value=\"2\"]\n")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("message")).click();
        WebElement uploadElement = driver.findElement(By.id("fileUpload"));
        uploadElement.sendKeys("C://Users/arieh/Pictures/Screenshots/Screenshot (4).png");

        driver.findElement(By.id("submitMessage")).click();
        Thread.sleep(1000);
        String msgupload = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li\n")).getText();
        Assert.assertTrue("Text not found!", msgupload.contains("The message cannot be blank."));

        driver.quit();
    }
}