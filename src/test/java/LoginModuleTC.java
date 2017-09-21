import org.testng.annotations.Test;

public class LoginModuleTC extends Drivers{

    @Test
    //Be able to login as an existing user
    public void LoginExistingUser (){

       PageObjects.existingUser("fieldlenstest1@mailinator.com", "testing123");

    }

    @Test
    //Be able to create a new user
    public void CreateNewUser(){

        PageObjects.newUser("fieldlenstest99@mailinator.com", "testing123", "FirstName",
                "LastName","12345678910", "QA tester", "Test Company",
                3, 3);

    }
}
