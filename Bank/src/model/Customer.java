package model;

import java.util.UUID;

public class Customer
{
    public Customer(String NAME, double BALANCE)
    {
        id = UUID.randomUUID().toString();
        name = NAME;
        balance = BALANCE;
    }

    private String id;
    private String name;
    private double balance;

    public String getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getName()
    {
        return name;
    }

    public void setBalance(double BALANCE) {
        balance = BALANCE;
    }
}
