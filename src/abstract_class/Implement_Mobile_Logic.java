package abstract_class;

public class Implement_Mobile_Logic extends MobilePhone {



    public static void main(String args[]) throws Exception{
    Implement_Mobile_Logic obj = new Implement_Mobile_Logic();
    obj.mobile_vibration();
    obj.mobile_company();


}
    public void mobile_vibration(){
        System.out.println("Mobile Vibration should be low");
    }

}
