import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import pages.HamburgerMenuContentPage;
import pages.HomePage;
import pages.ResultsPage;
import pages.TvDepartmentPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void TestTvDescriptionForSecondItem() {
        HomePage home_obj = PageFactory.initElements(driver, HomePage.class);
        HamburgerMenuContentPage menu_obj = PageFactory.initElements(driver, HamburgerMenuContentPage.class);
        TvDepartmentPage tv_obj = PageFactory.initElements(driver, TvDepartmentPage.class);
        ResultsPage res_obj = PageFactory.initElements(driver, ResultsPage.class);

        driver.get(HOME_PAGE_URL);
        driver.get("https://www.amazon.in/");
        System.out.print(driver.getTitle());
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        home_obj.clickOnHamburgerButton();
        menu_obj.clickOnTvFromMenuItem();
        menu_obj.clickOnTvSubFromMenuItem();
        tv_obj.selectSamSungFromBrands();
        res_obj.clickOnSortDropDown();
        res_obj.clickOnHighToLowOption();
        res_obj.clickOnSecondTVFromResults();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
