public class customer
{
    static String account_no= "";
    //String password= "";
    String name = "";
    String address = "";
    String phone_no= "";

    String account_type= ""; // saving or checking
    account a;  // composition
    public customer(String name, String account_no, String address, String phone_no, String account_type)
    {
        this.name = name ;
        this.phone_no= phone_no;
        this.account_type= account_type;
        this.address= address;
        this.account_no= account_no;

    }


    // -------------- Constructor --------------

     void printStatement()
     {
         System.out.println("Print statement...");
         System.out.println("Name: ");
         System.out.println("Account no: ");
         System.out.println("address: ");
         System.out.println("Phone_no: ");
         System.out.println("Balance: ");

     }
    public void checkBalance()
    {

    }
    public void display()
    {
        System.out.println("Name : " + this.name);
        System.out.println("Address : " + this.address);
        System.out.println("Phone_no : " + this.phone_no);
        System.out.println("Account type : " + this.account_type);
        System.out.println("Account NUMBER  : " + this.account_no);


    }


}
