package bdd;

import helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjectPattern.Pages.CreateAnAccountPage;

import java.time.Duration;
import java.util.Random;

public class NewAccountRegistration {

    private WebDriver driver;

    @Given("user is on the Testlab Hotel website")
    public void userIsOnTheHttpsHotelTestlabCoderslabPlEnWebsite() {
        driver = WebDriverFactory.createChromeDriver();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("click SignIn button")
    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.className("hide_xs"));
        signInButton.click();
    }

    @And("insert {string} addres and click Create an account button")
    public void insertEmailAddresAndClickCreateAnAccountButton(String email) {

//        String email = "jak.to.zrobic11@mail.pl";

        //w przypadku użycia poniższego podmienić w insertEmailAddres na myGeneratedEmail
//        Random random = new Random();
//        String myGeneratedEmail = random.nextInt(1000) + "test" + random.nextInt(1000) + "@mail.pl";

        WebElement insertEmailAddres = driver.findElement(By.cssSelector(".is_required.validate.account_input.form-control"));
        insertEmailAddres.sendKeys(email);

        WebElement createAnAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAnAccountButton.click();
    }

    @And("insert {string} in First name box and insert {string} in Last name box and insert {string} in Password box and click Register button")
    public void insertNameInFirstNameBoxAndInsertSurnameInLastNameBoxAndInsertPasswordInPasswordBoxAndClickRegisterButton(String name, String surname, String password) {
//
//        String name = "Janusz";
//        String surname = "Kowalewski";
//        String password = "asdfg";

        WebElement insertName = driver.findElement(By.id("customer_firstname"));
        insertName.sendKeys(name);
        WebElement insertSurname = driver.findElement(By.id("customer_lastname"));
        insertSurname.sendKeys(surname);
        WebElement insertPassword = driver.findElement(By.id("passwd"));
        insertPassword.sendKeys(password);
        WebElement registrationButton = driver.findElement(By.id("submitAccount"));
        registrationButton.click();
    }

    @Then("new account should be created and account page displayed")
    public void newAccountShouldBeCreatedAndAccountPageDisplayed() {

//        String expectedName = "Janusz";
//
//        WebElement accountConfirmation = driver.findElement(By.id("user_info_acc"));
//        String realName = accountConfirmation.getText();
//
//        Assertions.assertEquals(expectedName, realName);


    }
}
