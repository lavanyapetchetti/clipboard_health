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

public class TvDepartmentPage {
    WebDriver driver;
    public TvDepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'a-size-base') and text() = 'Samsung']")
    private WebElement Samsung;

    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'a-size-base') and text() = 'Department']")
    private WebElement Department;

    public void selectSamsungFromBrands() {
        String URL = driver.getCurrentUrl();
        driver.get(URL);
        driver.findElement(By.xpath("//*[contains(@class, 'a-size-base') and text() = 'Department']")).isDisplayed();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2600)");
        ExpectedConditions.visibilityOf(Samsung);
        Samsung.click();
    }
}
