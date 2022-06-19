package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TvDepartmentPage {
    WebDriver driver;
    public TvDepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'a-size-base') and text() = 'Samsung']")
    private WebElement Samsung;


    public void selectSamsungFromBrands() {
        String URL = driver.getCurrentUrl();
        driver.navigate().to(URL);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2600)");
        ExpectedConditions.visibilityOf(Samsung);
        Samsung.click();
    }
}
