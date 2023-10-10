import java.util.Scanner;
public class checking extends account
{
    Scanner sc = new Scanner(System.in);
    static String account_no = "";

    int tax = 0;
    int transactions = 0;
    int transaction_fee = 0;
    public checking(String account)
    {
        this.account_no= account;
    }
    public void displayAllDeductions()
    {
        System.out.println("Your total deductions are " + tax);
    }

    public void makeDeposit()
    {
        if (this.transactions> 2)
        {
            this.transaction_fee= this.transaction_fee+ 10;
        }
        System.out.println("Enter amount to deposit");
        int x = sc.nextInt();
        System.out.println("Money deposited");
        this.balance= this.balance + x;
    }
    public void makeWithdrawal()
    {
        if (this.transactions> 2)
        {
            this.transaction_fee= this.transaction_fee+ 10;
        }
        System.out.println("Enter amount to withdraw");
        int x = sc.nextInt();
        System.out.println("Money withdrawn");
        this.balance= this.balance- x;


    }

}
