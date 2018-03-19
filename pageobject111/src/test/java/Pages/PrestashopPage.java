package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrestashopPage {
    private EventFiringWebDriver driver;
    //    private By userIcon=By.id("employee_infos");
//    private By exitButton=By.id("header_logout");
//    private By menuItemsList=By.xpath("//li[contains(@class,\"maintab\") and contains(@class,\"has_submenu\")]");
    private By allProducts=By.cssSelector("a[href*=\"2-home\"]");

    public PrestashopPage(EventFiringWebDriver driver){
        this.driver=driver;
    }
    public void allProductLinkClick(){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(allProducts));
        driver.findElement(allProducts).click();
    }
}
