package model;

import java.util.UUID;

public class Transaction implements Comparable<Transaction>
{
    public Transaction(String SENDERID, String RECIEVERID, double SUM, int DELAY)
    {
        id = UUID.randomUUID().toString();
        senderId = SENDERID;
        recieverId = RECIEVERID;
        sum = SUM;
        delayTime = DELAY;
    }

    private String id;
    private String senderId;
    private String recieverId;
    private double sum;
    private int delayTime;

    public String GetId()
    {
        return id;
    }

    public String GetSender()
    {
        return senderId;
    }

    public String GetReciever()
    {
        return recieverId;
    }

    public double GetSum()
    {
        return sum;
    }

    @Override
    public int compareTo(Transaction o) {
        return delayTime - o.delayTime;
    }
}
