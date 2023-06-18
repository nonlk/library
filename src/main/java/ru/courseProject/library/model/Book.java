package ru.courseProject.library.model;

public class Book {

    private Integer id;
    private String bookName;
    private String authorName;
    private Integer qty;

    public Book(Integer id, String bookName, String authorName, Integer qty) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.qty = qty;
    }

    public Book(String bookName, String authorName, Integer qty) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.qty = qty;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}