import model.Customer;
import model.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner in = new Scanner(System.in);
        String input;
        while (true)
        {
            System.out.println("Commands: ");
            System.out.println("Add-customer");
            System.out.println("Del-customer");
            System.out.println("Create-transaction");
            System.out.println("Show-customers");
            System.out.println("Show-transactions");
            System.out.println("Run-transactions");
            System.out.println("Get-customer-by-id");

            input = in.nextLine();
            switch (input)
            {
                case ("Add-customer"):
                    System.out.print("Enter customers name: ");
                    String name = in.nextLine();
                    System.out.print("Enter customers balance: ");
                    double balance = Double.parseDouble(in.nextLine());
                    Customer customer = new Customer(name, balance);
                    bank.AddCustomer(customer);
                    System.out.println("model.Customer " + name + " created with id " + customer.getId());
                    break;
                case ("Del-customer"):
                    System.out.print("Enter customers id: ");
                    String id = in.nextLine();
                    bank.DeleteCustomer(id);
                    System.out.println("model.Customer deleted");
                    break;
                case ("Create-transaction"):
                    System.out.print("Enter senders id: ");
                    String senderId = in.nextLine();
                    System.out.print("Enter recievers id: ");
                    String recieverId = in.nextLine();
                    System.out.print("Enter sum of transaction: ");
                    double sum = Double.parseDouble(in.nextLine());
                    System.out.print("Enter delay: ");
                    int delay = Integer.parseInt(in.nextLine());
                    try {
                        if(bank.AddTransaction(new Transaction(senderId, recieverId, sum, delay)))
                        {
                            System.out.println("model.Transaction added");
                        }else
                        {
                            System.out.println("model.Transaction didnt added");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case ("Show-customers"):
                    bank.GetAllCustomers();
                    break;
                case ("Show-transactions"):
                    bank.GetTransactions();
                    break;
                case ("Run-transactions"):
                    bank.RunTransactions();
                    break;
                case ("Get-customer-by-id"):
                    System.out.print("Enter customers id: ");
                    String ID = in.nextLine();
                    System.out.println(bank.PrintCustomer(bank.GetCustomerById(ID)));
                default:
                    System.out.println("Unknown command");
                    break;
            }

            if(input == "exit")
            {
                break;
            }
        }
    }
}