package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {
    private EventFiringWebDriver driver;

    private  String bl="//div [@class=\"product-description\"]";
    public MainPage(EventFiringWebDriver driver){
        this.driver=driver;
    }
    public void nameLinkClick(String pName){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bl+" //a [contains(text(),\""+pName+"\")]")));
        WebElement prodlink=driver.findElement(By.xpath(bl+" //a[contains(text(),\""+pName+"\")]"));    //a [contains(text(),"Blouse")]
        System.out.println(prodlink.toString());
        prodlink.click();
    }
}
