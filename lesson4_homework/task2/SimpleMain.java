package org.example.lesson4_homework.task2;

public class SimpleMain {
    public static void main(String[] args) {
        ParcelSend letter = new Letter("Letter","Museum Strasse 23","Hintere Gasse 31");
        letter.send();
        letter.deliver();
        ParcelSend banderole = new Banderole("Banderole","Museum Strasse 23","Hintere Gasse 31","brown");
        banderole.send();
        banderole.deliver();
        ParcelSend parcel = new Parcel("Parcel","Museum Strasse 23","Hintere Gasse 31");
        parcel.send();
        parcel.deliver();
        ParcelSend container = new Container("Container","Museum Strasse 23","Hintere Gasse 31",52);
        container.send();
        container.deliver();
    }
}
