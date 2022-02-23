package pageObjectPattern.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

    private final WebDriver driver;

    @FindBy (className = "hide_xs" )
    private WebElement signInButton;

    @FindBy (css = ".is_required.validate.account_input.form-control")
    private WebElement inputEmail;

    @FindBy (id = "SubmitCreate")
    private WebElement submitCreate;

    @FindBy (id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy (id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy (id = "passwd")
    private WebElement inputPassword;

    @FindBy (id = "submitAccount")
    private WebElement submitCreateButton;

    @FindBy (css = "p.alert.alert-success")
    private WebElement alertMessage;


    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void inputEmail(String email) {
        inputEmail.sendKeys(email);
        submitCreate.click();
    }

    public void inputCredentials(String firstName, String lastName, String password) {
        customerFirstName.sendKeys(firstName);
        customerLastName.sendKeys(lastName);
        inputPassword.sendKeys(password);
        submitCreateButton.click();
    }

    public String getRegistrationConfirmation() {
        return alertMessage.getText();

    }
}
