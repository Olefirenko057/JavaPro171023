package org.example.lesson4_homework.task2;

public class Letter extends ParcelSend{

    public Letter(String name, String senderAddress, String recipientAddress) {
        super(name, senderAddress, recipientAddress);
    }

    @Override
    public void deliver() {
        System.out.println(getRecipientAddress() + " has received the " + getName() +".The letter is so informative");
    }

    @Override
    public void send() {
        System.out.println(getSenderAddress() + " has send the " + getName() + " to " + getRecipientAddress());
    }
}
