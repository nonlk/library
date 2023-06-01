package ru.courseProject.library.model;

public class Reservation {

    private Integer id;
    private String readerCard;
    private Integer bookId;
    private String date;
    private String time;

    public Reservation() {
    }

    public Reservation(String readerCard, Integer bookId,
                       String date, String time) {
        this.readerCard = readerCard;
        this.bookId = bookId;
        this.date = date;
        this.time = time;
    }

    public Reservation(Integer id, String readerCard, Integer bookId,
                       String date, String time) {
        this.id = id;
        this.readerCard = readerCard;
        this.bookId = bookId;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReaderCard() {
        return readerCard;
    }

    public void setReaderCard(String readerCard) {
        this.readerCard = readerCard;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
