import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Drivers {


    public static WebDriver driver;

    //setting up
    @BeforeTest
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");

        driver = new ChromeDriver();

        /* To Maximize the window */
        driver.manage().window().maximize();

        /* To delete all the cookies of the browser */
        driver.manage().deleteAllCookies();


    }


    @AfterTest
    public void tearDown (){

        driver.close();

    }
}
