package reusables;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Reusables {

    public String read_Excel(String testcasename,String param)
    {
        String excel_data=null;
        try{
            //String excel_path=System.getProperty("user.id")+"\\TestData\\Automatio_test_Data.xlsx";
            String excel_path=read_PropertiesFile("excel_path");
            String excel_sheet_name=read_PropertiesFile("sheet_name");
            //String excel_path="C:\\Users\\sandeepkm\\IdeaProjects\\Edyoda_Testing\\TestData\\Automatio_test_Data.xlsx";
            //Read the Excel path
            FileInputStream fls=new FileInputStream(excel_path);
            // Get the Workbook access
            Workbook workbook=new XSSFWorkbook(fls);
            // Read data from specific sheet
            Sheet sheet=workbook.getSheet(excel_sheet_name);
            int RC_count=sheet.getLastRowNum();
            //System.out.println("Get the row number  " +RC_count);
            for (int i=0;i<=RC_count;i++)
            {
                Row row=sheet.getRow(i);
                int Col_count=row.getLastCellNum();
                // System.out.println("Total column count of row number:" +Col_count);
                Cell cell=row.getCell(0);
                String value=cell.getStringCellValue();
                //System.out.println("the columan value is --->" +value);
                //System.out.println("******************");
                if(value.equals(testcasename))
                {
                    //System.out.println("The row number is :"+i);
                    Row newrow=sheet.getRow(0);

                    for(int j=0;j<Col_count;j++)
                    {
                        Cell cellnum=newrow.getCell(j);
                        String valueofcell=cellnum.getStringCellValue();
                        if(valueofcell.equals(param))
                        {
                            //System.out.println("The URL is"+sheet.getRow(i).getCell(j));
                            excel_data=sheet.getRow(i).getCell(j).toString();
                        }


                    }
                }
            }
        }
        catch (Exception e)
        {

        }
        return excel_data;
    }

    public String read_PropertiesFile(String key){
        String value = null;

        try{
            FileReader reader = new FileReader(System.getProperty("user.dir")+"\\testdata.properties");
            Properties prop = new Properties();
            prop.load(reader);
            value=prop.getProperty(key);



        }
        catch(Exception e){

        }
        return value;

    }
    public Response Get_Res_Post_call(String URL, String body)
    {
        Response res=null;
        try
        {
            res=given()
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .post(URL);
        }

        catch (Exception e)
        {

        }
        return res;

    }

    public Response Get_Pet_Res_Post_call(String URL, String body)
    {
        Response res=null;
        try
        {
            res=given()
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .post(URL);
        }

        catch (Exception e)
        {

        }
        return res;

    }

    public Response SOAP_XML_Response_Body(String URL, String body,String header)
    {
        Response res=null;
        try
        {
            res=given()
                    .relaxedHTTPSValidation()
                    //.header(header.split(",")[0],header.split(",")[1])
                    .header("Content-Type","application/soap+xml; charset=utf-8")
                    .body(body)
                    .when()
                    .post(URL);
        }

        catch (Exception e)
        {

        }
        return res;

    }


}
