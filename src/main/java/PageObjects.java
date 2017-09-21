import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class PageObjects extends Drivers {

    //Enter email address at login page
    public static void emailAddressExisting(String emailAddress){
        Wait.waitForId("login-email");
        driver.findElement(By.id("login-email")).clear();
        driver.findElement(By.id("login-email")).sendKeys(emailAddress);
    }

    //Enter password at the login page
    public static void passwordExisting (String password){
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    //Click the 'Login' button at the login page
    public static void loginButtonExisting (){
        driver.findElement(By.xpath(".//*[@id='account-login']/div/div[2]/div/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div/div/button")).click();
    }

    //Click the 'Sign Up' button to create new user
    public static void signupNewUser (){
        Wait.waitForXpath(".//*[@id='account-login']/div/div[2]/div/div[3]/div/div/div/span/a");
        driver.findElement(By.xpath(".//*[@id='account-login']/div/div[2]/div/div[3]/div/div/div/span/a")).click();
    }

    //Enter email address for new user
    public static void emailAddressNewUser (String emailAddress){
        driver.findElement(By.id("registration-email")).clear();
        driver.findElement(By.id("registration-email")).sendKeys(emailAddress);
    }

    //Enter password for the new user
    public static void passwordNewUser (String password){
        driver.findElement(By.id("registration-password")).clear();
        driver.findElement(By.id("registration-password")).sendKeys(password);
    }

    //Enter Confirm password for the new user
    public static void confirmPasswordNewUser (String confirmPassword){
        driver.findElement(By.id("registration-password-confirm")).clear();
        driver.findElement(By.id("registration-password-confirm")).sendKeys(confirmPassword);
    }

    //Click the register 'Let's go' button to create the new user
    public static void registerButtonNewUser (){
        driver.findElement(By.cssSelector(".generic-button.blue")).click();
    }

    //Enter first name for new user
    public static void firstNameNewUser (String firstName){
        Wait.waitForId("registration-first-name");
        driver.findElement(By.id("registration-first-name")).clear();
        driver.findElement(By.id("registration-first-name")).sendKeys(firstName);
    }

    //Enter last name for new user
    public static void lastNameNewUser (String lastName){
        driver.findElement(By.id("registration-last-name")).clear();
        driver.findElement(By.id("registration-last-name")).sendKeys(lastName);
    }

    //Enter phone number for new user
    public static void phoneNumNewUser (String phoneNumber){
        driver.findElement(By.id("registration-phone")).clear();
        driver.findElement(By.id("registration-phone")).sendKeys(phoneNumber);
    }

    //Enter job title for new user
    public static void jobTitleNewUser (String jobTitle){
        driver.findElement(By.id("registration-job-title")).clear();
        driver.findElement(By.id("registration-job-title")).sendKeys(jobTitle);
    }

    //Click the 'Next' button to create the new user
    public static void clickNextButtonNewUser (){
        driver.findElement(By.cssSelector(".generic-button.blue")).click();
    }

    //Enter the Company name
    public static void companyNameNewUser (String companyName){
        Wait.waitForId("registration-company-name");
        driver.findElement(By.id("registration-company-name")).clear();
        driver.findElement(By.id("registration-company-name")).sendKeys(companyName);
    }

    //Expand the Company Type drop down menu and select from the menu options 2-5
    // 2 = GC / Construction Manager
    // 3 = Subcontractor / Supplier
    // 4 = Designer / Consultant
    // 5 = Owner / Owner's Representative
    public static void companyTypeNewUser (int companyTypeNum) {
        Select dropComType = new Select (driver.findElement(By.id("registration-company-type")));
        dropComType.selectByIndex(companyTypeNum);
    }

    //Expand the Company Discipline drop down menu and select from the menu options 2-3
    // 2 = Construction Manager
    // 3 = General Contractor
    public static void companyDisciplineNewUser (int companyDisciplineNum){
        driver.findElement(By.id("registration-discipline-id")).click();
        Wait.waitForXpath(".//*[@id='registration-discipline-id']/option["+companyDisciplineNum+"]");
        driver.findElement(By.xpath(".//*[@id='registration-discipline-id']/option["+companyDisciplineNum+"]")).click();
    }

    //Login as existing user
    public static void existingUser (String emailAddress, String password){

        driver.get("https://app.fieldlens.com");

        PageObjects.emailAddressExisting(emailAddress);

        PageObjects.passwordExisting(password);

        PageObjects.loginButtonExisting();
    }

    //Create new user
    public static void newUser (String emailAddress, String password, String firstName, String lastName, String phoneNum, String jobTitle, String companyName, int companyType, int companyDiscipline){

        driver.get("https://app.fieldlens.com");

        PageObjects.signupNewUser();

        PageObjects.emailAddressNewUser(emailAddress);

        PageObjects.passwordNewUser(password);

        PageObjects.confirmPasswordNewUser(password);

        PageObjects.registerButtonNewUser();

        PageObjects.firstNameNewUser(firstName);

        PageObjects.lastNameNewUser(lastName);

        PageObjects.phoneNumNewUser(phoneNum);

        PageObjects.jobTitleNewUser(jobTitle);

        PageObjects.clickNextButtonNewUser();

        PageObjects.companyNameNewUser(companyName);

        PageObjects.companyTypeNewUser(companyType);

        PageObjects.companyDisciplineNewUser(companyDiscipline);

        PageObjects.registerButtonNewUser();

        PageVerify.verifyNewUserWelcomeModal();
    }
}
