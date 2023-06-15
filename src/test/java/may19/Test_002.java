package may19;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_002 {

    @BeforeClass
    public void do_setUpfor_TC002(){
        System.out.println("Starting API server for TC002");
    }

    @Test(priority = 1)
    public void testing_FireFoxPage (){

        System.out.println("I am executing in FireFox");
    }
    @Test(priority = 2)
    public void testing_EdgePage (){

        System.out.println("I am executing in Edge");
    }
    @Test(priority = 3)
    public void testing_AmazonPage (){

        System.out.println("I am executing in Amazon");
    }

    @AfterClass
    public void closing_allServers_forTC002(){
        System.out.println("Closing all servers for TC002");
    }







}
