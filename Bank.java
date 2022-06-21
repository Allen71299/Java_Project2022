package bank_project;

import java.io.*;
import java.util.*;

public class Bank {

    long accno;
    String name;
    float balance;

    public Bank(long accno, String name, float balance) {
        this.accno = accno;
        this.name = name;
        this.balance = balance;


    }


    public static void details(String cust_name, long cust_accno, float cust_balance) {

        System.out.println("\nName is :" + cust_name);
        System.out.println("Account Number is :" + cust_accno);
        System.out.println("Account Balance is :" + cust_balance);

    }


    public static void main(String args[]) throws IOException {
        long accno;
        String name;
        float balance;
        long phoneno;
        long search;
        Scanner sc = new Scanner(System.in);
        ArrayList < Bank > list = new ArrayList < Bank > ();

        while (true) {

            System.out.println("\nEnter 1 to Register ");
            System.out.println("Enter 2 to Login");
            System.out.println("Enter 3 to find details of all customers");
            System.out.println("Enter 4 exit");
            int choice = sc.nextInt();


            switch (choice) {

                case 1:
                    {

                        System.out.println("Enter Account Number :");
                        accno = sc.nextLong();
                        sc.nextLine();
                        System.out.println("Enter Name : ");
                        name = sc.nextLine();
                        System.out.println("Enter Balance :");
                        balance = sc.nextFloat();
                        Bank obj = new Bank(accno, name, balance);
                        list.add(obj);
                        System.out.println("Congratulations " + name + " you have successfully registered ");
                        break;
                    }

                case 2:
                    {
                        System.out.println("Welcome to login portal");
                        System.out.println("Enter your account number ");
                        search = sc.nextLong();
                        ListIterator itr = list.listIterator();

                        while (itr.hasNext()) {
                            Bank ob = (Bank) itr.next();
                            if (ob.accno == search) {
                                System.out.println(ob.name + " you have logged in successfully ");
                                System.out.println("\nEnter 1 to deposit,");
                                System.out.println("Enter 2 to withdraw");
                                System.out.println("Enter 3 to check balance");
                                int ch = sc.nextInt();

                                switch (ch) {
                                    case 1:
                                        {
                                            System.out.println("Enter the amount you want to deposit");
                                            float amount = sc.nextFloat();
                                            ob.balance = ob.balance + amount;
                                            System.out.println(ob.name + " you have successfully deposited amount :" + amount);
                                            System.out.println("Your updated account balance is :" + ob.balance);
                                            break;
                                        }
                                    case 2:
                                        {
                                            System.out.println("Enter the amount you want to withdraw");
                                            float amount = sc.nextFloat();
                                            if ((ob.balance - amount) < 1000) {
                                                System.out.println("Sorry minimum balance required to mantain is : 1000");
                                                System.out.println("Your Current balance is : " + ob.balance);
                                                System.out.println("The maximum amount you can withdraw now is : " + (ob.balance - 1000));
                                            } else {
                                                ob.balance = ob.balance - amount;
                                                System.out.println(ob.name + " you have successfully withdrawn amount :" + amount);
                                                System.out.println("Your updated account balance is :" + ob.balance);

                                            }
                                            break;
                                        }
                                    case 3:
                                        {
                                            details(ob.name, ob.accno, ob.balance);
                                            break;
                                        }

                                }

                                break;

                            } else if (itr.hasNext() == false) {

                                System.out.println("Sorry account not found,please register first ");
                            }


                        }

                        break;
                    }

                case 3:


                    {

                        ListIterator itr = list.listIterator();
                        while (itr.hasNext()) {
                            Bank ob = (Bank) itr.next();
                            details(ob.name, ob.accno, ob.balance);

                        }


                        break;

                    }



                case 4:

                    {

                        System.out.println("Exiting portal");
                        System.exit(0);
                        break;

                    }


                default:
                    {

                        System.out.println("Sorry Wrong input");
                        break;
                    }
            }

        }


    }
}
