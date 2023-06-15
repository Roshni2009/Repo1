package learningloopCondition;

public class Understanding_IfElse {

    public static void main (String[] args) throws Exception{
        Understanding_IfElse obj1 = new Understanding_IfElse();
        System.out.println(obj1.rate_of_interest("pnb"));


    }

    public int rate_of_interest(String bankName){
        int rateofinterest = 0;

        if (bankName.equals("sbi"))
        {
            rateofinterest = 8;
        }
        if (bankName.equals("pnb"))
        {
            rateofinterest = 7;
        }
        if (bankName.equals("axis"))
        {
            rateofinterest = 4;
        }
        if (bankName.equals("hsbc"))
        {
            rateofinterest = 10;
        }
        if (bankName.equals("hdfc"))
        {
            rateofinterest = 11;
        }
        return rateofinterest;
    }


}
