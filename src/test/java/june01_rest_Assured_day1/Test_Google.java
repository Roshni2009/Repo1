package june01_rest_Assured_day1;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reusables.Reusables;


public class Test_Google {

    //helps to generate automated test reports
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;

    Reusables res_obj;

    @BeforeClass
    public void setup() {
        res_obj = new Reusables();

        //create an object to extend reports
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/TestReport/Google.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("AppVersion", "1.2");
        extent.setSystemInfo("UserName", "Roshni");
        spark.config().setDocumentTitle("Doing google testing for Google APIs --GetCall(), PostCall()");
        spark.config().setTheme(Theme.DARK);
        logger = extent.createTest("Creating test report for google API");

    }

    @Test
    public void do_google_get_call_validation() {

        try {
            RestAssured.baseURI = res_obj.read_PropertiesFile("google_url");
            logger.info("get API calls for https://google.com ");
            Response google_response = RestAssured.get();
            int google_status_code = google_response.getStatusCode();
            System.out.println("The status code = " + google_status_code);
            Assert.assertEquals(google_response.getStatusCode(), 200);
            logger.pass("The status code is as expected as -->" + google_status_code);
            String google_response_text = google_response.asString();
            System.out.println("The response is = " + google_response_text);
            Assert.assertTrue(google_response_text.contains("<title>Google</title>"));
            logger.pass("The response string is as expected as -->" + google_response_text);
            }
        catch (Exception e) {
            logger.fail(e);
            logger.fail("Api get call validation for google is not working");
        }

    }

    @Test
    public void do_w3schools_get_call_validation() {
        try {
            RestAssured.baseURI = res_obj.read_PropertiesFile("w3schools_url");
            logger.info("get API calls for https://www.w3schools.com ");
            Response w3schools_response = RestAssured.get();
            int w3schools_status_code = w3schools_response.getStatusCode();
            System.out.println("The status code = " + w3schools_status_code);
            Assert.assertEquals(w3schools_response.getStatusCode(), 200);
            logger.pass("The status code is as expected as -->" + w3schools_status_code);
            String w3schools_response_text = w3schools_response.asString();
            System.out.println("The response is = " + w3schools_response_text);
            Assert.assertTrue(w3schools_response_text.contains("<title>W3Schools Online Web Tutorials</title>"));
            logger.pass("The response string is as expected as -->" + w3schools_response_text);

            }
        catch(Exception e){
            logger.fail(e);
            logger.fail("Api get call validation for w3schools is not working");

        }
    }


    @AfterClass
    public void tearDown() {
        extent.flush();
    }
}

