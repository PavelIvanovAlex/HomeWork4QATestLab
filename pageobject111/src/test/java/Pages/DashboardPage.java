package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private EventFiringWebDriver driver;
    private By products=By.id("subtab-AdminProducts");
    private By catalog=By.id("subtab-AdminCatalog");

    public DashboardPage(EventFiringWebDriver driver){
        this.driver=driver;
    }

   public void productsItemClick(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(products));
        driver.findElement(products).click();
    }
    public void catalogMouseHover(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(catalog));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(catalog)).build().perform();
    }
}
