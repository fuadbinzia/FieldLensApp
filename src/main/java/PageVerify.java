import org.openqa.selenium.By;
import org.testng.Assert;

public class PageVerify extends Drivers {

    public static void verifyNewUserWelcomeModal (){

        //Assert if the welcome modal loads for first time user
        Wait.waitForXpath(".//*[@id='welcome-series']/div/div/div[2]/div/div/button");
        String verifyButton = driver.findElement(By.xpath("//*[@id='welcome-series']/div/div/div[2]/div/div/button")).getText();
        Assert.assertEquals(verifyButton, "Get started");

    }

}
