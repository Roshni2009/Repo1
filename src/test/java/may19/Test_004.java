package may19;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_004 {
    @Test
    @Parameters({"Name","Pwd"})
    public static void GoogleLogin(String Name, String Pwd){
        System.out.println("Enter Name :"+Name);
        System.out.println("Enter Password :"+Pwd);
    }

    @Test
    @Parameters({"StatusCode"})
    public void Validate_Get_Call(String StatusCode){
        String RunTime_Status_Code = "200";
        Assert.assertEquals(RunTime_Status_Code,StatusCode);
        Assert.assertTrue(RunTime_Status_Code.equals(StatusCode));
        Assert.assertTrue(Integer.parseInt(RunTime_Status_Code)==Integer.parseInt(StatusCode));


    }

    @Test
    public void Facebook_Testing(){
        System.out.println("We are doing Facebook Testing");
    }




}
