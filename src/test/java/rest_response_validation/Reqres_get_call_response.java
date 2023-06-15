package rest_response_validation;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Reqres_get_call_response {
    @Test
    @Parameters({"support_text"})
    public void Regress_get_call_validation(String support_text){
        Response res = given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        int get_status_code = res.getStatusCode();
        System.out.println("The status code is --->" +get_status_code);
        String get_call_res =res.getBody().jsonPath().getString("support.text");
        Assert.assertEquals(support_text,get_call_res);
        System.out.println("The response string is ----->" +get_call_res);

    }
    @Test
    @Parameters({"auth_confirm"})
    public void authorization_validation(String auth_confirm){
        String URI = "https://httpbin.org/basic-auth/user/passwd";
        Response res =given()
                .auth()
                .basic("user","passwd")
                .when()
                .get(URI);
        int get_auth_status_code = res.getStatusCode();
        System.out.println("The status code is --->" +get_auth_status_code);
        Assert.assertTrue(get_auth_status_code == 200);
        String get_auth_response_text = res.getBody().jsonPath().getString("authenticated");
        System.out.println("The response text is ---->"+get_auth_response_text);
        Assert.assertEquals(get_auth_response_text,auth_confirm);

    }
}
