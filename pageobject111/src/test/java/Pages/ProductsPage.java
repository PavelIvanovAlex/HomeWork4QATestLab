package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private EventFiringWebDriver driver;
    private By addProductButton = By.id("page-header-desc-configuration-add");


    public ProductsPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void addProductButtonClick() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(addProductButton));
        driver.findElement(addProductButton).click();
    }
}
