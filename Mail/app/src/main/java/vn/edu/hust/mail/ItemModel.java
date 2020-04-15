package vn.edu.hust.mail;

public class ItemModel {

    public ItemModel(String name, String header, String content, String timeStamp) {
        this.name = name;
        this.header = header;
        this.content = content;
        this.timeStamp = timeStamp;
        favorite = false;
        choosen = false;
    }

    String timeStamp;
    String name;
    String header;
    String content;
    boolean favorite;
    boolean choosen;
}