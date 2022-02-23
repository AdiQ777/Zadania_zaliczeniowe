package Selectors1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Zadanie1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        //Zadanie1

//        driver.findElement(By.id("hotel_location")).sendKeys("Warsaw");
//
//        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));
//
//        WebElement newsletterEmailInput = driver.findElement(By.id("newsletter-input"));
//        newsletterEmailInput.sendKeys("test@test.com");


        //Zadanie2
//        WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
//        WebElement searchNowButton = driver.findElement(By.name("search_room_submit"));
//        WebElement newsletterEmailInput = driver.findElement(By.name("email"));
//        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));
//
//        hotelLocationInput.sendKeys("Warsaw");
//        newsletterEmailInput.sendKeys("test@test.com");
//        searchNowButton.click();

        //Zadanie3
        WebElement signInButton = driver.findElement(By.className("hide_xs"));
        signInButton.click();
        WebElement newsletterEmailInput = driver.findElement(By.cssSelector(".is_required.validate.account_input.form-control"));
        newsletterEmailInput.sendKeys("test@blaaa.com");
        driver.findElement(By.id("SubmitCreate")).click();

        //Zadanie4
//        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Paolo");
//        driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Kovalsky");
//        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("zxxcvv");

        //Zadanie Funkcje
        WebElement searchFirstName = driver.findElement(By.id("customer_firstname"));
                if (searchFirstName.isDisplayed()) {
                    searchFirstName.sendKeys("Paolo");
                }else {
                    throw new NoSuchElementException("Element nie jest wyświetlony");
                }
        WebElement searchLastName = driver.findElement(By.id("customer_lastname"));
                if (searchLastName.isDisplayed()) {
                    searchLastName.sendKeys("Kovalsky");
                }else {
                    throw new NoSuchElementException("Element nie jest wyświetlony");
                }
        WebElement searchPassword = driver.findElement(By.id("passwd"));
                if (searchPassword.isDisplayed()) {
                    searchPassword.sendKeys("zxxcvb");
                }else {
                    throw new NoSuchElementException("Element nie jest wyświetlony");
        }
        driver.findElement(By.id("SubmitCreate")).click();



    }
}
