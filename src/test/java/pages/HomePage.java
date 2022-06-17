package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(how=How.ID, using = "nav-hamburger-menu")
    private WebElement hamburger_menu;
    public void Select_hamburger_menu() {
        hamburger_menu.click();
    }

}
