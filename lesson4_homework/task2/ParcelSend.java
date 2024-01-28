package org.example.lesson4_homework.task2;

public abstract class ParcelSend {
    private String name;
    private String senderAddress;
    private String recipientAddress;

    public ParcelSend(String name, String senderAddress, String recipientAddress) {
        this.name = name;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
    }

    public abstract void deliver();
    public abstract void send();

    public String getName() {
        return name;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }
}
