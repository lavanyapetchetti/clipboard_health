package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class HamburgerMenuContentPage {
    WebDriver driver;

    public HamburgerMenuContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(linkText="TV, Appliances, Electronics")
    private WebElement hamburger_menu_item_tv;

    @FindBy(how = How.XPATH, using= "//*[contains(@class, 'hmenu-item') and text() = 'Televisions']")
    private WebElement hamburger_menu_item_tv_sub;

    public void clickOnTvFromMenuItem() {
        ExpectedConditions.visibilityOf(hamburger_menu_item_tv);
        hamburger_menu_item_tv.click();
    }

    public void clickOnTvSubFromMenuItem() {
        hamburger_menu_item_tv_sub.click();
    }

}
