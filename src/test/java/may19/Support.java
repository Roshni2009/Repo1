package may19;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Support {
    @BeforeSuite
    public void do_Setup_before_Execution(){
        System.out.println("Do database connection");
    }

    @AfterSuite
    public void complete_Setup_after_Execution(){
        System.out.println("Disconnect the database");
    }



}
