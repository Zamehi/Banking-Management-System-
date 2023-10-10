import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
abstract public class account
{
    Scanner sc = new Scanner(System.in);
    int balance= 0;
    String type = "";
    String date_created = "";


    void printStatement()
    {

    }
    public abstract void makeWithdrawal();
    public abstract void makeDeposit();
    void checkBalance()
    {
        //System.out.println("Name    : "+ this.); // display nae too
        System.out.println("Balance : " + this.balance);

    }

    void transferAmount()
    {
        String x = ""; int b= 0;
        System.out.println("Enter the transfer account number ");
        x = sc.nextLine();
        System.out.println("Enter the transfer amount");
        b = sc.nextInt();


    }
    public abstract void displayAllDeductions();



}

