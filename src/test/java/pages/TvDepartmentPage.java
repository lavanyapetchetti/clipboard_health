package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

public class TvDepartmentPage {
    WebDriver driver;
    public TvDepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'a-size-base') and text() = 'Samsung']")
    private WebElement Samsung;


    public void selectSamSungFromBrands() {
        try {
            String URL = driver.getCurrentUrl();
            driver.navigate().to(URL);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2600)");
            ExpectedConditions.visibilityOf(Samsung);
            Samsung.click();
        } catch (NoSuchElementException e) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
