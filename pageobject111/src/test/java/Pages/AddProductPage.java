package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AddProductPage {
    private EventFiringWebDriver driver;
    private By name = By.id("form_step1_name_1");
    private By quantity = By.xpath("//div [@class=\"row\"]// input[@id=\"form_step1_qty_0_shortcut\"]");
    private By price = By.id("form_step1_price_ttc_shortcut");
    private By active=By.xpath("//div [contains(@class,\"switch-input\")]");
    private By saveButton=By.xpath("//button [contains(@class, \"btn\")and contains(@class, \"btn-primary\") and contains(@class, \"js-btn-save\")] ");
    private By message=By.className("growl-message");


    public AddProductPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }
    public void nameInput(String productName){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(name));
        driver.findElement(name).sendKeys(productName);
    }
    public void quantityInput(String productQuantity){
         WebElement qtyField=driver.findElement(quantity);
         qtyField.sendKeys(productQuantity);
    }
    public void priceInput(String productPrice){
        WebElement priceField=driver.findElement(price);
        priceField.sendKeys(productPrice);
   }
    public void saveButtonClick() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
    }
    public  void activeCheck(){
        driver.findElement(active).click();
    }
    public void messageShow(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(message));
        Assert.assertTrue(driver.findElement(message).getText().contains("Настройки"),"Message is not shown");

    }
}
