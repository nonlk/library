package ru.courseProject.library.model;

public class Reservation {

    private Integer id;
    private String readerCard;
    private Integer bookId;
    private String date;
    private String time;
    private Boolean verification;

    public Reservation() {
    }

    public Reservation(String readerCard, Integer bookId,
                       String date, String time, Boolean verification) {
        this.readerCard = readerCard;
        this.bookId = bookId;
        this.date = date;
        this.time = time;
        this.verification = verification;
    }

    public Reservation(Integer id, String readerCard, Integer bookId,
                       String date, String time, Boolean verification) {
        this.id = id;
        this.readerCard = readerCard;
        this.bookId = bookId;
        this.date = date;
        this.time = time;
        this.verification = verification;
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

    public Boolean getVerification() {
        return verification;
    }

    public void setVerification(Boolean verification) {
        this.verification = verification;
    }
}
