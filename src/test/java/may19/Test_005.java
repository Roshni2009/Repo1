package may19;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import reusables.Reusables;

import org.testng.annotations.Test;

public class Test_005 {
    private Reusables re_obj;

    @BeforeClass
    public void do_initial_steps(){
        re_obj = new Reusables();

    }

    @Test(groups = {"End2End","SmokeTest","P1"})
        public void TestAPI_001(){
        System.out.println("Executing Test API 001");
        System.out.println("URL is  " +re_obj.read_PropertiesFile("url"));
    }

    @Test(groups = {"Regression"})
    public void TestAPI_002(){
        System.out.println("Executing Test API 002");
    }

    @Test(groups = {"SmokeTest"})
    public void TestAPI_003(){
        System.out.println("Executing Test API 003");
        System.out.println("The email is  " +re_obj.read_PropertiesFile("email"));
    }

    @Test(groups = {"End2End"})
    public void TestAPI_004(){
        System.out.println("Executing Test API 004");
    }

    @Test(groups = {"Regression"})
    public void TestAPI_005(){
        System.out.println("Executing Test API 005");
    }

    @Test(groups = {"SmokeTest"})
    public void TestAPI_006(){
        System.out.println("Executing Test API 006");
    }

    @Test(groups = {"End2End"})
    public void TestAPI_007(){
        System.out.println("Executing Test API 007");
    }

    @Test(groups = {"Regression"})
    public void TestAPI_008(){
        System.out.println("Executing Test API 008");
    }

    @Test(groups = {"SmokeTest"})
    public void TestAPI_009(){
        System.out.println("Executing Test API 009");
    }

    @Test(groups = {"End2End"},priority = 1)
    public void TestAPI_010(){
        System.out.println("Executing Test API 010");
    }



}
