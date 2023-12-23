import model.Customer;
import model.Transaction;

import java.util.ArrayList;
import java.util.Comparator;

public class Bank
{
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Customer AddCustomer(Customer customer)
    {
        customers.add(customer);
        return customer;
    }

    public void DeleteCustomer(String ID) {

        Customer customer = GetCustomerById(ID);
        customers.remove(customer);

    }

    public ArrayList<Customer> SortCustomers(Comparator<Customer> comparator)
    {
        customers.sort(comparator);
        return customers;
    }


    public ArrayList<Customer> GetCustomersByName(String name)
    {
        ArrayList<Customer> tempCustomers = new ArrayList<>();
        for(Customer c : customers)
        {
            if(c.getName().contains(name))
            {
                tempCustomers.add(c);
            }
        }
        return tempCustomers;
    }

    public void GetAllCustomers(){
        for (Customer customer: customers){
            System.out.println("Name: " + customer.getName() + " id: " + customer.getId() + " balance: " + customer.getBalance());
        }
    }
    public Customer GetCustomerById(String ID)
    {
        for(Customer customer: customers)
        {
            if(customer.getId().equals(ID))
            {
                return customer;
            }
        }
        System.out.println("model.Customer didnt found");
        return null;
    }
    public String PrintCustomer(Customer customer){
        return "Name: " + customer.getName() + ", balance: " + customer.getBalance();
    }
    public boolean AddTransaction(Transaction transaction) throws Exception {
        if((GetCustomerById(transaction.GetSender()) == null) || (GetCustomerById(transaction.GetReciever()) == null))
        {
            throw new Exception("CustomerNotFoundException");
        }
        if(GetCustomerById(transaction.GetSender()).getBalance() < transaction.GetSum())
        {
            return false;
        }
        transactions.add(transaction);
        transactions.sort(Comparator.naturalOrder());
        return true;
    }

    public void ChangeBalance(String senderId, String receiverId, double sum){
        Customer sender = GetCustomerById(senderId);
        Customer receiver = GetCustomerById(receiverId);
        sender.setBalance(sender.getBalance() - sum);
        receiver.setBalance(receiver.getBalance() + sum);
        customers.set(customers.indexOf(GetCustomerById(senderId)), sender);
        customers.set(customers.indexOf(GetCustomerById(receiverId)), receiver);
    }
    public void RunTransactions()
    {
        for(Transaction transaction : transactions)
        {
            ChangeBalance(transaction.GetSender(), transaction.GetReciever(), transaction.GetSum());
            System.out.println("Transaction " + transaction.GetId() + " completed");
        }
        System.out.println("Transactions completed");
    }

    public void GetTransactions()
    {
        for(Transaction transaction : transactions)
        {
            System.out.println("Transaction id: " + transaction.GetId() + " Sender id: " + transaction.GetSender() + " Reciever id: " + transaction.GetReciever() + " sum: " + transaction.GetSum());
        }
    }
}
