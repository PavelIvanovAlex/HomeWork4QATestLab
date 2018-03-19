import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.BaseTest;

import java.util.concurrent.TimeUnit;

public class MyTestNGTest extends BaseTest {
    private static EventFiringWebDriver driver;
    private final Object[][] productData=new Object[][]{{RandomData.RandomString(),RandomData.RandomInt(),RandomData.RandomDouble()}};

    @DataProvider (name = "Autentication")
    public Object[][] loginData(){
        return new Object[][]{{"webinar.test@gmail.com","Xcg7299bnSmMuRLp9ITw"}};
    }
    @BeforeTest
    @Parameters("browser")
    public  void initDriverTest(@Optional("FF") String browser) {
        driver = getDriver(browser);
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.manage().window().maximize();
    }
    @Test (dataProvider = "Autentication")
     public  void AutenticationTest(String login, String password) {
        LoginPage logPage = new LoginPage(driver);
        logPage.openPage("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");// http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/
        logPage.inputLogin(login);
        logPage.inputPassword(password);
        logPage.loginButtonClick();
    }
    @Test (dependsOnMethods = {"AutenticationTest"})
    public  void NavigateToAddProductTest() {
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.catalogMouseHover();
        dashboardPage.productsItemClick();

        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.addProductButtonClick();

    }


    @Test (dependsOnMethods = {"NavigateToAddProductTest"})
    public  void AddNewProductTest() {

        String productName=(String) productData[0][0];
        String productQty=(String) productData[0][1];
        String productPrice=(String) productData[0][2];

        AddProductPage addProductPage=new AddProductPage(driver);
        addProductPage.nameInput(productName);
        addProductPage.quantityInput(productQty);
        addProductPage.priceInput(productPrice);
        addProductPage.activeCheck();
        addProductPage.messageShow();
        addProductPage.saveButtonClick();
        
    }

    @Test (dependsOnMethods = {"AddNewProductTest"})
    public  void shopTest() {
        String productName=(String) productData[0][0];
        String productQty=(String) productData[0][1];
        String productPrice=(String) productData[0][2];
        System.out.println(productName+"  "+productQty+"   "+productPrice);

        driver.get("http://prestashop-automation.qatestlab.com.ua/");
        PrestashopPage shopMainPage=new PrestashopPage(driver);
        shopMainPage.allProductLinkClick();
        MainPage mainPage=new MainPage(driver);
        mainPage.nameLinkClick(productName);

        ProductPage productPage=new ProductPage(driver);
        productPage.productNamePresent(productName);
        productPage.productQtyPresent(productQty);
        productPage.productPricePresent(productPrice);

  }

  @AfterTest
    public  void tearDown(){
      quitDriver(driver);
  }

}
