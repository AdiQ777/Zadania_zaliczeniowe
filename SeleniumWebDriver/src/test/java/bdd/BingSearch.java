package bdd;

import helpers.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BingSearch {

    private WebDriver driver;

    @Given("an open browser with bing.com")
    public void anOpenBrowserWithBingCom() {
        driver = WebDriverFactory.createChromeDriver();
        driver.get("https://www.bing.com");
    }

    @When("a keyword selenium is entered in input field and clicks search button")
    public void aKeywordSeleniumIsEnteredInInputFieldAndClicksSearchButton() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("selenium");
        searchInput.submit();
    }

    @Then("the first result should contain selenium")
    public void theFirstResultShouldContainSelenium() {
        System.out.println("wyświetliło");
    }

    @And("close browser")
    public void closeBrowser() {
        driver.close();
    }
}
