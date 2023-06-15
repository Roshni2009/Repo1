package june13_2023;

import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import requestBody.Request_Body;
import reusables.Reusables;

import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

import static io.restassured.RestAssured.given;

public class SOAP_Get_Call {
    public Request_Body obj;
    public Reusables excel_obj;
    public String testcase_id=null;

    @BeforeClass
    public void setup()
    {
        obj=new Request_Body();
        excel_obj=new Reusables();
    }


    @Test
    public void Get_call_Book_store(){
        Response res = given()
                .relaxedHTTPSValidation()
                .when()
                .get("https://chercher.tech/sample/api/books.xml");
        //System.out.println(res.getBody().asString());
        XmlPath xml_path_obj = new XmlPath(res.getBody().asString()).using(xmlPathConfig().namespaceAware(false));
        int book_count = xml_path_obj.get("bookstore.book.size()");
        System.out.println("Total book count is --->" +book_count);
        String book_name = xml_path_obj.getString("bookstore.book[0].title");
        System.out.println("The first book title is --->" +book_name);
        String book_lang = xml_path_obj.getString("bookstore.book[0].title.@lang");
        System.out.println("The first book language is --->" +book_lang);
        String book_category = xml_path_obj.getString("bookstore.book[1].@category");
        System.out.println("The Second book category is --->" +book_category);
    }

    @Test
    public void post_call_validation(){
        Response res1 = given()
                .relaxedHTTPSValidation()
                .header("Content-Type","application/soap+xml; charset=utf-8")
                .body("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                        "  <soap12:Body>\n" +
                        "    <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
                        "      <Celsius>20</Celsius>\n" +
                        "    </CelsiusToFahrenheit>\n" +
                        "  </soap12:Body>\n" +
                        "</soap12:Envelope>")
                .when()
                .post("https://www.w3schools.com/xml/tempconvert.asmx");
        System.out.println(res1.getBody().asString());
        XmlPath xml_path_obj = new XmlPath(res1.getBody().asString()).using(xmlPathConfig().namespaceAware(false));
        String Fahrenheit_res = xml_path_obj.get("soap12:Envelope.soap:Body.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult");
        System.out.println(Fahrenheit_res);
        String excel_data=excel_obj.read_Excel(testcase_id,"FahrenheitValue");
        System.out.printf("******"+excel_data);
        if(excel_data.contains(".0")||excel_data.contains(".00"))
        {
            int Fahren_Res=Integer.parseInt(Fahrenheit_res);
            Assert.assertEquals(Fahren_Res,Integer.parseInt(excel_data));
        }
        else
        {
            Assert.assertEquals(Fahrenheit_res,excel_data);
        }

    }


}
