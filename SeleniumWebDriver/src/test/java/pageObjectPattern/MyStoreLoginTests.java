package pageObjectPattern;

import helpers.WebDriverFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.Pages.CreateAnAccountPage;
import pageObjectPattern.Pages.LoginPage;
import pageObjectPattern.Pages.RandomHotelSearch;
import pageObjectPattern.Pages.ShoppingCart;

import java.time.Duration;

public class MyStoreLoginTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createChromeDriver();

        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

//    @AfterEach
//    public void tearDown() {
//        //driver.quit();
//    }

//    @Test
//    public void noPageObjectLoginWithProperCredentials() {
//        WebElement emailInput = driver.findElement(By.name("email"));
//        emailInput.sendKeys("johnd@mail.com");
//
//        WebElement passwordInput = driver.findElement(By.name("password"));
//        passwordInput.sendKeys("qwerty");
//
//        WebElement signInButton = driver.findElement(By.id("submit-login"));
//        signInButton.click();
//
//        WebElement userNameLabel = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"));
//        Assertions.assertEquals("John Doe", userNameLabel.getText());
//    }
//
    @Test
    public void loginWithProperCredentials() {
        // arrange
        String email = "johnd@mail.com";
        String password = "qwerty";
        LoginPage loginPage = new LoginPage(driver);

        // Random random = new Random();
        // String myEmail = "User" + random.nextInt(1000000) + "@mail.com";

        // act
        loginPage.loginAs(email, password);

        // assert
        Assertions.assertEquals("John Doe", loginPage.getLoggedUsername());
    }

    @Test
    public void createNewAccount() {
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);

        String email = "adambanana11@blah.pl";
        String firstName = "Adam";
        String lastName = "Banana";
        String password = "qwert";

        createAnAccountPage.clickSignIn();
        createAnAccountPage.inputEmail(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        createAnAccountPage.inputCredentials(firstName, lastName, password);

        Assertions.assertEquals("Your account has been created.", createAnAccountPage.getRegistrationConfirmation());
    }

    @Test
    public void hotelSearch() {
        RandomHotelSearch randomHotelSearch = new RandomHotelSearch(driver);
        ShoppingCart shoppingCart = new ShoppingCart(driver);

        String location = "Poland";
        String email = "adambanana11@blah.pl";
        String password = "qwert";
        String checkInDate = "19-02-2022";
        String checkOutDate = "22-02-2022";
        String roomName = "Delux Rooms";

        randomHotelSearch.signInAction(email, password);
        randomHotelSearch.hotelSearch(location, checkInDate, checkOutDate);
        shoppingCart.roomSelector(roomName);


    }
}
