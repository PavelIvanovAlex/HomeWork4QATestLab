package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

public class ProductPage {
    private EventFiringWebDriver driver;

    private By name = By.xpath("//div [@class=\"col-md-6\"] / h1[(@class=\"h1\")]");
    private By quantity = By.xpath("//div [@class=\"product-quantities\"]/span");
    private By price = By.xpath("//div [@class=\"current-price\"]/span[@itemprop=\"price\"]");

    public ProductPage(EventFiringWebDriver driver){
        this.driver=driver;
    }
    public void productNamePresent(String pName){
        System.out.println(driver.findElement(name).getText());
        Assert.assertTrue(driver.findElement(name).getText().toUpperCase().equals(pName.toUpperCase()),"No such product "+pName);
            }
    public void productPricePresent(String pPrice){
        System.out.println(driver.findElement(price).getAttribute("content"));
        Assert.assertTrue(driver.findElement(price).getAttribute("content").equals(pPrice.toUpperCase()),"No such price "+pPrice);
    }
    public void productQtyPresent(String pQty){
        String currQty=driver.findElement(quantity).getText();
        System.out.println(currQty.substring(0,currQty.indexOf(' ')));
        Assert.assertTrue(currQty.substring(0,currQty.indexOf(' ')).equals(pQty),"No such quantity "+pQty);

    }
}
