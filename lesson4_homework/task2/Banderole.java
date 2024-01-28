package org.example.lesson4_homework.task2;

public class Banderole extends ParcelSend {
    private String packageColor;

    public Banderole(String name, String senderAddress, String recipientAddress, String packageColor) {
        super(name, senderAddress, recipientAddress);
        this.packageColor = packageColor;
    }

    @Override
    public void deliver() {
        System.out.println(getRecipientAddress() + " has received the " + getName() +".The color of the package is " + packageColor);
    }

    @Override
    public void send() {
        System.out.println(getSenderAddress() + " has send the " + packageColor + " " + getName() + " to " + getRecipientAddress());
    }
}
