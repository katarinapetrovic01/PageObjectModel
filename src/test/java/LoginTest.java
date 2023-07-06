import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    ChromeDriver driver;
    LoginPage loginPage;
    @BeforeMethod

    public void setUp(){

        driver = browseropen();
        loginPage = new LoginPage(driver);

    }
    @Test
    public void LoginOnPage(){

        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Test
    public void InvalidUserName() {

        loginPage.setUserName("standard_user");
        loginPage.setPassword("pass");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginOnPageWhitOutPass()
    {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Password is required");
    }

    @AfterMethod

    public void after() {driver.quit();}



}
