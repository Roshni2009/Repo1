package may17;

public class call_Encap_Class {


    public static void main(String args[]) throws Exception{


        understand_Encapsulation obj = new understand_Encapsulation();
        obj.setAge(20);
        System.out.println("The Actual Age =="+obj.getAge());

        obj.setMobileData(123 , "#123");
        System.out.println("The Balance is  ==>"+obj.getMobileData());


    }





}




