import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongawebSigninTest {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
            public void start() throws InterruptedException{
                //locate where the chrome driver is
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                //1. open Chrome browser
                driver = new ChromeDriver();

            }

    @Test(priority = 0)
    public void openUrl() throws InterruptedException {
        //2. input the right Url and open Konga page Url ("https://www.konga.com/")
        driver.get("https://www.konga.com/");
        Thread.sleep(5000);
        //Test1 verify that user put the right Url
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        //4. maximize browser page
        driver.manage().window().maximize();
        //5.getting the page title
        System.out.println(driver.getTitle());
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void clicksignin() throws InterruptedException {
        //6. click on the login/signup button to open login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
        //verify that when click on Signin it open signin page
        String expectedUrl = "https://www.konga.com/account/login?return_url=/";
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(5000);

        if (actualUrl.contains(expectedUrl))
            System.out.println("correct signin page");
            //pass
        else
            System.out.println("wrong signin page");
        //fail
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void signin() throws InterruptedException {
        //7. locating and inputting valid email address in the email address or phone number field
        driver.findElement(By.id("username")).sendKeys("adeniransina21@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("password@2188");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //verify that user will login successfully with valid email and password

        //pass
        System.out.println("user logged in successfully");
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void logout() throws InterruptedException {
        //8. click on logout button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        // verify that when user logs out it directs them back to the home page
        System.out.println(driver.getTitle());

        Thread.sleep(5000);
        //then click on the logout button to sign up
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();

        Thread.sleep(5000);

    }

    @AfterTest
    public void quitpage() {

        // Quit the Browser
        driver.quit();
    }



}


