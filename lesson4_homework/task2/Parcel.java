package org.example.lesson4_homework.task2;

import java.util.Random;

public class Parcel extends ParcelSend {
    private final String[] content = new String[]{"clothes","utensil","cosmetics","sweets","furniture","books"};
    private final String item;

    public Parcel(String name, String senderAddress, String recipientAddress) {
        super(name, senderAddress, recipientAddress);
        Random r = new Random();
        this.item = content[r.nextInt(content.length)];
    }

    @Override
    public void deliver() {
        System.out.println(getRecipientAddress() + " has received the " + getName() + " of " + item);
    }

    @Override
    public void send() {
        System.out.println(getSenderAddress() + " has sent the " + item + " to " + getRecipientAddress());
    }
}
