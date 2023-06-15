package testng;
import java.text.*;
import java.util.*;
public class Java_Collections {
    static Java_Collections_1 test;

    public static String ordernumber;

    public static final String muname = "mithun";

    int sum=0;

    int roll = 10;
    String student_name = "MITHUN";
    String address = "123 Road , New Delhi";
    float interest = 7.2f;
    boolean checkForLogin  = false;

    String AC_Comp = "AC_001";

    String date = "05-09-2023";

    String ordetNumber_API = "10023456789";
    String ordetNumber_DB = "10023456789";

    String mobile = "10000";
    String watch = "2000";
    String tax = "20";

    int a = 10;
    int b = 20;
    int c = 30;


    String a1 = "10";
    String b1 = "20";
    String c1 = "30";

    int balance = 100;



    public static void main(String[] args) throws Exception{

        // Create an object ...

        Java_Collections obj = new Java_Collections();
        test = new Java_Collections_1();




        //System.out.println("I am learning Java Program ......");

        //System.out.println("Welcome to Java  ......");

        //System.out.println(obj.roll);
        //System.out.println("Sum is ===>"+Integer.valueOf(obj.watch)+Integer.valueOf(obj.mobile)+Integer.valueOf(obj.tax));
        //System.out.println(obj.a+obj.b+obj.c);

        //System.out.println(obj.a1+obj.b1+obj.c1);

        int x = Integer.parseInt(obj.a1);
        int y = Integer.parseInt(obj.b1);
        int z = Integer.parseInt(obj.c1);

        //System.out.println(x+y+z);

        System.out.println("Today's Date is ==>"+obj.get_date_and_time());

        System.out.println("My mobile balance is"+" "+String.valueOf(obj.balance));

        System.out.println(obj.addNumbers());
        System.out.println(addNumbers_1());


    }


    public String get_date_and_time(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        return dateFormat.format(date);
    }

    public void addTwoNumbers(){
        int sum1 = 0;
        sum = 5+5;
        sum1 = 7+7;
    }

    public void addThreeNumbers(){
        sum = 5+5+5;
        //sum1 = 6+6;
    }

    public int addNumbers(){
        sum = 20+40+test.anotherClassRoll;
        return sum;
    }

    public static int addNumbers_1(){
        return 200;
    }











}
