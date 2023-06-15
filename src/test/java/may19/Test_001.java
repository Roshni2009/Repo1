package may19;

import com.beust.jcommander.Parameter;
import org.testng.annotations.*;

public class Test_001 {

    @BeforeTest
    public void do_setUpfor_TC001(){
        System.out.println("Starting API server for TC001");
    }

    @Test(priority = 1)
    public void testing_googlePage(){
        System.out.println("I am executing my first test scripts");
    }

    @Test(priority = 2)
    @Parameters({"Num"})
    public void testing_faceBookPage(String Num){

        System.out.println(100+100+Integer.valueOf(Num));
    }

    @AfterTest
    public void closing_allServers_forTC001(){
        System.out.println("Closing all servers for TC001");
    }












}
