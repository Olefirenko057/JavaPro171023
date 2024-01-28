package org.example.lesson4_homework.task2;

public class Container extends ParcelSend {
    private int sizeKg;

    public Container(String name, String senderAddress, String recipientAddress, int sizeKg) {
        super(name, senderAddress, recipientAddress);
        this.sizeKg = sizeKg;
    }

    @Override
    public void deliver() {
        if (sizeKg > 50)
            System.out.println(getRecipientAddress() + " has received the " + getName() + ".It is big and heavy");
        else
            System.out.println(getRecipientAddress() + " has received the " + getName() + ".It is not so heavy");
    }

    @Override
    public void send() {
        System.out.println(getSenderAddress() + " has send " + sizeKg + " kilogram "  + getName() + " to " + getRecipientAddress());
    }
}
