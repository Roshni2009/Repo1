package june05_2023_post_Call;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


import requestBody.Request_Body;

public class E2E_pet_creation_Code {
    private ExtentSparkReporter spark;
    private ExtentReports extent;
    private ExtentTest logger;
    public Request_Body req_obj;
    @BeforeClass
    public void setUp(){
        req_obj = new Request_Body();
        extent = new ExtentReports();
        spark= new ExtentSparkReporter(System.getProperty("user.dir") + "/TestReport/Postcall.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Enviornment","QA");
        extent.setSystemInfo("App version","1.2");
        extent.setSystemInfo("UserName","Roshni");
        spark.config().setDocumentTitle("Doing testing for Post call--  postcalls");
        spark.config().setTheme(Theme.DARK);
        logger = extent.createTest("Creating testreport for Postcalls");
    }
    @Test
    public void pet_id_E2E_testing(){
        for (int i=200;i<210;i++){
            String id = String.valueOf(i);
            String name = "Animal_" +id;
            create_PetID(id,name);
            validate_pet_id(id);
            delete_pet_id(id);
        }

    }
    public void create_PetID(String pet_id, String pet_name){

        Response res = given()
                .contentType(ContentType.JSON)
                .body(req_obj.createPet_Request_Body(pet_id, pet_name))
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        int create_post_status_code = res.getStatusCode();
        System.out.println("The status code is =" +create_post_status_code);
        String pet_id_res = res.getBody().jsonPath().getString("id");
        String pet_name_res = res.getBody().jsonPath().getString("name");
        System.out.println("The Pet ID is =" +pet_id_res);
        System.out.println("The Name is =" +pet_name_res);
        //to print in report
        logger.pass("The status code is ---->" +create_post_status_code);
        logger.info("The pet id is --->" +pet_id);
        logger.info("The pet name is ---->" +pet_name);
    }
    public void validate_pet_id(String pet_id){
        String runtime_pet_id = "https://petstore.swagger.io/v2/pet/"+pet_id;
        Response res =given()
                .when()
                .get(runtime_pet_id);
        int get_status_code = res.getStatusCode();
        System.out.println("The status code is --->" +get_status_code);
        Assert.assertTrue(get_status_code == 200);
        //to print in report
        logger.pass("The status code is ---->" +get_status_code);


    }

    public void delete_pet_id(String pet_id){
        String pet_id_delete = "https://petstore.swagger.io/v2/pet/"+pet_id;
        Response res =given()
                .when()
                .delete(pet_id_delete);
        int delete_status_code = res.getStatusCode();
        System.out.println("The status code is --->" +delete_status_code);
        Assert.assertTrue(delete_status_code == 200);
        logger.pass("The delete status code is ---->" +delete_status_code);
    }


    @AfterClass
    public void tearDown(){
        extent.flush();
    }

}
