import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

   @Test
   public void openUrl() throws InterruptedException {

       //2. input your selenium demo page url(http://selenium-blog.herokuapp.com)
       driver.get("http://selenium-blog.herokuapp.com");
       Thread.sleep(5000);
       //3. maximize brower
       driver.manage().window().maximize();
       //4. click on signup button to open the signup page
       driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
       Thread.sleep(5000);
       //5. input your username in the username field
       driver.findElement(By.id("user_username")).sendKeys("tundze11");
       //6. input your email in the username field
       driver.findElement(By.id("user_email")).sendKeys("lank4real11@yahoo.com");
       //7. locate the password filed and input your password on the user name filed
       driver.findElement(By.id("user_password")).sendKeys("fresh21");
       //8. click on the sign on button
       driver.findElement(By.id("submit")).click();
       Thread.sleep(5000);
       //9. click on user one on the listpage
       driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
       Thread.sleep(5000);
       //10. search for an item(learn xpath) and confirm it is present
       driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
       Thread.sleep(5000);
       //11. click logout
       driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
   }

   @AfterTest
    public void closebrowser(){
       //quite the browser
       driver.quit();
   }























   }