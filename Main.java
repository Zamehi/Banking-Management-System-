import java.util.Iterator;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.io.*;

public class Main<T>
{
    static int number = 1000;

    private Class<T> objectType;
    private String filePath;



    // ------------------------------   Constructor   --------------------------
    public Main(Class<T> objectType, String filePath)
    {
        this.objectType = objectType;
        this.filePath = filePath;
    }

    // --------------------------   Write object to csv file --------------------


    // --------------------------  unique account number generator  --------------
    public static void no_generator (String filePath,  String str)
    {
        int flag = 0;
       // String str= "";
        try (BufferedReader csvReader = new BufferedReader(new FileReader(filePath)))
        {

            String line;
            String lastRow = null;

            // Read the file line by line
            while ((line = csvReader.readLine()) != null)
            {
                lastRow = line;
            }

            if (lastRow != null)
            {
                // Split the last row by the CSV delimiter (e.g., comma)
                String[] columns = lastRow.split(",");

                if (columns.length >= 1)
                {
                    str = columns[0];
                    int intValue = Integer.valueOf(str);
                    intValue+=1;
                    str = String.valueOf(intValue);
                   // System.out.println("First Column of Last Row: " + str);
                }
                else
                {
                    System.out.println("CSV file is empty or has no columns.");
                    flag = 1;
                }
            }
            else
            {
                System.out.println("CSV file is empty.");
                flag = 1;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    if (flag == 1)
    {
        str= "1000";
    }


}

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<customer> personList = new ArrayList<>();
        List<saving> personList1 = new ArrayList<>();
        List<checking> personList2 = new ArrayList<>();




        // fILE to read from
        //String file_acc = "customer.csv";
        //String file_saving = "saving.csv";
        //String file_checking = "checking.csv";


        // Taking input

        // int x = 0;
        //x = sc.nextInt();


        String name, account_no, address, phone_no, account_type;
        int p = 1;
        while (p == 1)
        {
            System.out.println("-------------------------------------------------------");
            System.out.println("   Welcome to Z-Bank Management System  (づ ◕‿◕ )づ    ");
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Open an account");
            System.out.println("2. Close an account");
            System.out.println("3. Login");
            System.out.println("4. Update Interest Rate for Saving Acoount");
            System.out.println("5. Display Account Details");
            System.out.println("6. Display Account Deductions + Details ");
            System.out.println("7. Other Operations");
            System.out.println("-1. exit");
            int x = 0;
            x = sc.nextInt();
            while (x < -1 || x > 5)
            {
                System.out.println("Please enter a valid input");
                x = sc.nextInt();
            }
            // Open an account
            if (x == 1)
            {

                // Creat ean object
                // customer c = new customer();

                System.out.println("Enter name");
                name = sc.nextLine();
                name = sc.nextLine();
                System.out.println("The name is "+name);
                System.out.println("Enter address");
                address = sc.nextLine();
                System.out.println("Enter phone");
                phone_no = sc.nextLine();
                System.out.println("Enter type of account");
                account_type = sc.nextLine();
                account_no = String.valueOf(number + 1);
                personList.add(new customer(name, account_no, address, phone_no, account_type));

                // generated account number
                // no_generator(file_acc,c.account_no);

                // -----------Writing to csv file------------
                if (account_type == "checking")
                {
                    //checking ch = new checking();
                    personList2.add(new checking(account_no));

                }
                if (account_type == "saving") {
                    //saving s = new saving();
                    personList1.add(new saving(account_no));
                }
                //Main<customer>writing = new Main <>(customer.class,file_acc);


            }
            // Delete an account
            else if (x == 2)
            {
                int x1 = 0;
                System.out.println("1. Delete account \n 2. Delete saving account \n 3. Delete Checking account");
                String input = "";
                x1 = sc.nextInt();
                System.out.println("Enter account number");
                input = sc.nextLine(); // enter account number
                input = sc.nextLine(); // enter account number
                if (x1 == 1)
                {
                    Iterator<customer> iterator = personList.iterator();
                    while (iterator.hasNext()) {
                        customer c = iterator.next();
                        if (customer.account_no.equals(input))
                        {
                            iterator.remove(); // Remove the matching object
                        }
                    }
                    Iterator<saving> iterator1 = personList1.iterator();
                    while (iterator1.hasNext()) {
                        saving s = iterator1.next();
                        if (saving.account_no.equals(input)) {
                            iterator1.remove(); // Remove the matching object
                        }
                    }
                    Iterator<checking> iterator2 = personList2.iterator();
                    while (iterator2.hasNext()) {
                        checking k = iterator2.next();
                        if (checking.account_no.equals(input))
                        {
                            iterator2.remove(); // Remove the matching object
                        }
                    }


                } else if (x1 == 2)
                {
                    Iterator<saving> iterator1 = personList1.iterator();
                    while (iterator1.hasNext()) {
                        saving s = iterator1.next();
                        if (saving.account_no.equals(input)) {
                            iterator1.remove(); // Remove the matching object
                        }
                    }
                } else if (x1 == 3) {
                    Iterator<checking> iterator2 = personList2.iterator();
                    while (iterator2.hasNext()) {
                        checking k = iterator2.next();
                        if (checking.account_no.equals(input)) {
                            iterator2.remove(); // Remove the matching object
                        }
                    }
                }
            }
            // Login an account
            else if (x == 3)
            {
                String input1 = "";
                System.out.println("Enter account no.");
                input1 = sc.nextLine();
                input1 = sc.nextLine();
                customer foundPerson = null;
                int i =0;
                for (customer person : personList)
                {
                    if (customer.account_no.equals(input1))
                    {
                        System.out.println("Finding Person");
                        foundPerson = person;
                        break; // Stop searching after finding the first matching object
                    }
                    i++;
                }

                // Check if the object was found
                if (foundPerson != null)
                {
                    System.out.println("Person found: " + foundPerson);
                    System.out.println("1. make_deposit\n 2. withdraw\n 3. check balance\n 4. " +
                            "print statement\n 5. Transfer amount\n 6. calculate Zakat\n " +
                            "7. Display All deductions");


                    int pls = sc.nextInt();
                    if (pls == 1)
                    {
                        System.out.println("Enter deposit");
                        int dep = sc.nextInt();
                        System.out.println("Updating");
                        personList.get(i).a.balance = personList.get(i).a.balance + dep;
                        System.out.println("Updated");

                    } else if (pls == 2) {
                        System.out.println("Enter withdraw");
                        int dep = sc.nextInt();
                        personList.get(i).a.balance =personList.get(i).a.balance - dep;
                        System.out.println("Updated");

                    }
                    else if (pls == 3)
                    {
                        System.out.println("Your balance is ");
                        //int dep = sc.nextInt();
                        personList.get(i).a.checkBalance();
                      //  break; // Stop searching after finding the first matching object

                    }
                    else if (pls == 4)
                    {
                        personList.get(i).printStatement();

                    }
                    else if (pls == 5)
                    {
                        System.out.println("Transfer amount");
                        personList.get(i).a.transferAmount();


                    }
                    else if (pls == 6)
                    {
                        System.out.println("Enter deposit");
                        int dep = sc.nextInt();
                        personList.get(i).a.balance =personList.get(i).a.balance + dep;
                        System.out.println("Updated");
                        //foundPerson = person;
                        for (customer person : personList) {
                            if (customer.account_no.equals(input1))
                            {

                                break; // Stop searching after finding the first matching object
                            }
                        }

                    }

                } else
                {
                    System.out.println("Person not found.");
                }

            }
            // Update interest
            else if (x == 4)
            {
                int y = 0;
                System.out.println("Enter the interest for saving account");
                y = sc.nextInt();
                saving.interest = y;
            }
            // display account details
            else if (x ==5)
            {
                for (customer obj : personList)
                {
                    obj.display();
                }
                for (saving obj1 : personList1)
                {
                    System.out.println(obj1);
                }
                for (checking obj2 : personList2)
                {
                    System.out.println(obj2);
                }

            }



            // exitting the loop
            if (x == -1)
            {
                p = -1;
                break;
            }
        }
    }
}
