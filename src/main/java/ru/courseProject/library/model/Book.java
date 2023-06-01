package ru.courseProject.library.model;

public class Book {

    private Integer id;
    private String name;
    private String authorName;
    private Integer qty;

    public Book(Integer id, String name, String authorName, Integer qty) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.qty = qty;
    }

    public Book(String name, String authorName, Integer qty) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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