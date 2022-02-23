package pageObjectPattern.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCart {

    private WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // zadanie 3 - wyszukiwanie hotelu po nazwie
//        String roomSelector = "//p[text() = '" + roomName + "']/../a";
//        WebElement roomBookNowButton = driver.findElement(By.xpath(roomSelector));
//        roomBookNowButton.click();

    public void roomSelector(String roomName) {

    List<WebElement> rooms = driver.findElements(By.className("room_cont"));
    boolean elementFound = false;
        for (WebElement room : rooms
             ) {
        if (room.getText().contains(roomName)) {
            room.findElement(By.cssSelector("a.ajax_add_to_cart_button")).click();
            elementFound = true;
            break;
        }
    }
}
}

