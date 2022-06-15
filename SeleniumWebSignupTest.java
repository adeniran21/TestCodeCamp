import com.google.common.base.Predicates;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.System.*;

public class SeleniumWebSignupTest {

    //import the selenium WebDriver

    private WebDriver driver;


    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your chrome brower
        driver = new ChromeDriver();
    }

    @Test(priority = 0)
    public void openUrl() throws InterruptedException {
        //input the right url
        driver.get("http://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //Test1 verify that user put the right Url
        String expectedUrl = "http://selenium-blog.herokuapp.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        driver.manage().window().maximize();
        Thread.sleep(5000);

    }

    @Test(priority = 1)
    public void clicksignup() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test2 verify that when click Signup it opens signup page
        String expectedUrl = "http://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(5000);
        if (actualUrl.contains(expectedUrl))
        System.out.println("correct signup page");
        //pass

       else
        System.out.println("wrong signup page");
        //fail
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void positivesignup() throws InterruptedException {

        driver.findElement(By.id("user_username")).sendKeys("tundze76");
        driver.findElement(By.id("user_email")).sendKeys("lanky4real76@yahoo.com");
        driver.findElement(By.id("user_password")).sendKeys("fresh21");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        //Test3 verify that user will successfully signup with valid username,email and password
        String expectedTittle = "Alpha Blog";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTittle))
            //pass
            System.out.print("Sign up successful");
        else
            //fail
            System.out.println("Sign up fail");
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void clickuser1() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);

        //test4 verify that list of content is present in user1
        String expectedUrl = "http://selenium-blog.herokuapp.com/users/1";
        String actualUrl = (driver.getCurrentUrl());

        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct page");
        else
            //fail
            System.out.print("wronge page");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void clickxpath() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(5000);

        //test5 verify that learn Xpath will open the article content
        String expectedUrl = "http://selenium-blog.herokuapp.com/articles/59";
        String actualUrl = (driver.getCurrentUrl());

        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct page");
        else
            //fail
            System.out.println("wronge page");
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void signoutsuccesfully() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(5000);

        //test6 verify that user sign out will direct to home page
        String expectedUrl = "http://selenium-blog.herokuapp.com/";
        String actualUrl = (driver.getCurrentUrl());

        if (actualUrl.contains(expectedUrl))
            //pass

            System.out.println("logged out successfully");
        else
            //fail
            System.out.println("failed logged out");
        Thread.sleep(5000);
    }

    @Test(priority = 6)
    public void invalidusername() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //input invalidusername

        //test7 verify that invalid user name cannot signup succussfully

        driver.findElement(By.id("user_username")).sendKeys("d");
        driver.findElement(By.id("user_email")).sendKeys("lank4real12@yahoo.com");
        driver.findElement(By.id("user_password")).sendKeys("fresh21");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 7)
    public void emptysignupfield() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //test8 verify that empty sign up fields can not sign up successfully

        driver.findElement(By.id("user_username")).sendKeys(" ");
        driver.findElement(By.id("user_email")).sendKeys(" ");
        driver.findElement(By.id("user_password")).sendKeys(" ");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void invalidemailsignup() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);

        //test9 verify that invalid email can not signup successfully

        driver.findElement(By.id("user_username")).sendKeys("tunze12");
        driver.findElement(By.id("user_email")).sendKeys("lanky4rea12");
        driver.findElement(By.id("user_password")).sendKeys("fresh21");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 9)
    public void tooshortpassword() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //test10 verify that less than or equal to one character password can not sign up successfully

        driver.findElement(By.id("user_username")).sendKeys("tunze12");
        driver.findElement(By.id("user_email")).sendKeys("lanky4real12@yahoo.com");
        driver.findElement(By.id("user_password")).sendKeys("f");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void quitpage() {

        driver.quit();
    }


}

















































