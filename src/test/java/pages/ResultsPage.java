package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

public class ResultsPage {
    WebDriver driver;
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'a-dropdown-label') and text() = 'Sort by:']")
    private WebElement sortDropDown;

    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'a-dropdown-link') and text() = 'Price: High to Low']")
    private WebElement dropDownOption;

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, \"s-card-container\")])[2]")
    private WebElement secondTv;

    public void clickOnSortDropDown() {
        sortDropDown.click();
    }

    public void clickOnHighToLowOption() {
        dropDownOption.click();
    }

    public void clickOnSecondTVFromResults() {
        secondTv.click();
    }
}
