package may19;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_003 {

    @Test
    @Parameters({"UserID","Password"})
    public void enter_UserID(String UserID, String Password){
        System.out.println("Enter User ID :"+UserID);
        System.out.println("Enter Password :"+Password);
    }

}
