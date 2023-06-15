package requestBody;

public class Request_Body {
    public String createPet_Request_Body(String pet_id, String pet_name){
        String body = "{\n" +
                "  \"id\": "+pet_id+",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \""+pet_name+"\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        return body;
    }
    public String Crete_XML_Req_body(String Councd)
    {
        String Xml_body="<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <CapitalCity xmlns=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
                "      <sCountryISOCode>"+Councd+"</sCountryISOCode>\n" +
                "    </CapitalCity>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
        return Xml_body;
    }

    public String Create_User_ID_Req_body(String name,String job)
    {
        String User_Body="{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
        return User_Body;
    }
    public String Fahrenheit(String value){

        String user_value ="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
                "      <Celsius>"+value+"</Celsius>\n" +
                "    </CelsiusToFahrenheit>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        return user_value;

    }
}
