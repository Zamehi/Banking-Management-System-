public class saving extends account
{
    static String account_no="";
    int zakat = 0;
    static int interest ; // store interest in a file, can be set at runtime

    public saving(String account)
    {
        this.account_no= account;
    }
    void calculateZakat()
    {
        if (this.balance>=20000)
        {
            this.zakat = (int) ((this.balance*2.5)/100);
        }
    }
    void calculatelnterest()
    {
        System.out.println("The interest is "+ this.interest);

    }
    public void displayAllDeductions()
    {
        System.out.println("Your total deductions are "+ zakat);
    }
    public void makeDeposit()
    {

    }
    public void makeWithdrawal()
    {

    }
    public void display()
    {



    }


}
