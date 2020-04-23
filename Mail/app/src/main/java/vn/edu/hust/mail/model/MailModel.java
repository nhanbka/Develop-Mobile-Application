package vn.edu.hust.mail.model;

public class MailModel {

    private String timeStamp;
    private String name;
    private String header;
    private String content;
    private boolean favorite;
    private boolean choosen;

    public MailModel(String name, String header, String content, String timeStamp) {
        this.name = name;
        this.header = header;
        this.content = content;
        this.timeStamp = timeStamp;
        favorite = false;
        choosen = false;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isChoosen() {
        return choosen;
    }

    public void setChoosen(boolean choosen) {
        this.choosen = choosen;
    }
}