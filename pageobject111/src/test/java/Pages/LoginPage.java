package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private EventFiringWebDriver driver;
    private String email;//="webinar.test@gmail.com";
    private String password;//="Xcg7299bnSmMuRLp9ITw";
    private By login=By.id("email");
    private By passw=By.id("passwd");
    private By logButton=By.name("submitLogin");

    public LoginPage(EventFiringWebDriver driver){
        this.driver=driver;
    }
    public void openPage(String pageURL){
        driver.get(pageURL);
    }
    public void inputLogin(String email){
        //new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(login));
        driver.findElement(login).sendKeys(email);
    }
    public void inputPassword(String password){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(passw));

        driver.findElement(passw).sendKeys(password);
    }
    public void loginButtonClick(){
       // new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(logButton));
        driver.findElement(logButton).click();
    }

}
