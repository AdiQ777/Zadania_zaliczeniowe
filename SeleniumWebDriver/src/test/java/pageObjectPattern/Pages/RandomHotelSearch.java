package pageObjectPattern.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RandomHotelSearch {

    private final WebDriver driver;

    @FindBy (id = "email")
    private WebElement validEmail;

    @FindBy (id = "passwd")
    private WebElement validPassword;

    @FindBy (className = "hide_xs" )
    private WebElement signInButton;

    @FindBy (id = "SubmitLogin")
    private WebElement submitLogin;

    @FindBy (id = "header_logo")
    private WebElement headerLogo;

    @FindBy (id = "hotel_location")
    private WebElement hotelLocation;

    @FindBy (id = "hotel_cat_name")
    private WebElement hotelDropdown;

    @FindBy (xpath = "//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul/li")
    private WebElement hotelSelection;

    @FindBy (id = "check_in_time")
    private WebElement signInDate;

    @FindBy (id = "check_out_time")
    private WebElement signOutDate;

    @FindBy (id = "search_room_submit")
    private WebElement submitSearchButton;

    @FindBy (xpath = "//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/a")
    private WebElement roomSelect;


    public RandomHotelSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void signInAction(String email, String password) {
        signInButton.click();
        validEmail.sendKeys(email);
        validPassword.sendKeys(password);
        submitLogin.click();
    }

    public void hotelSearch(String location, String checkInDate, String checkOutDate) {
        headerLogo.click();
        hotelLocation.sendKeys(location);
        hotelDropdown.click();
        hotelSelection.click();
        signInDate.sendKeys(checkInDate);
        signOutDate.sendKeys(checkOutDate);
        submitSearchButton.click();
//        roomSelect.click();
    }

}
