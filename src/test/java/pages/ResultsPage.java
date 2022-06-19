package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsPage {
    WebDriver driver;
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'a-dropdown-label') and text() = 'Sort by:']")
    private WebElement sortDropDown;

    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'a-dropdown-link') and text() = 'Price: High to Low']")
    private WebElement dropDownOption;

    @FindBy(how = How.XPATH, using = "(//*[contains(@class, 's-card-container')])[2]")
    private WebElement secondTv;

    @FindBy(how =How.XPATH, using = " //*[contains(@class, 'a-size-base-plus a-text-bold')]")
    private WebElement aboutItem;
    
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'a-unordered-list a-vertical a-spacing-mini')]")
    private WebElement description;

    public void clickOnSortDropDown() {
        sortDropDown.click();
    }

    public void clickOnHighToLowOption() {
        dropDownOption.click();
    }

    public void openSecondTVFromResults() {
        String item, text;
        String parentHandle = driver.getWindowHandle();
        secondTv.click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if(!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
                item = aboutItem.getText();
                assertEquals("About this item", item);
                text = description.getText();
                System.out.println(text);
            }
        }
    }
}
