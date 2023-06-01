package ru.courseProject.library.model;

public class Reader {
    private Integer id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String readCard;

    public Reader() {
    }

    public Reader(String firstName, String lastName, String readCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.readCard = readCard;
    }

    public Reader(String firstName, String secondName,
                  String lastName, String readCard) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.readCard = readCard;
    }

    public Reader(Integer id, String firstName, String secondName,
                  String lastName, String readCard) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.readCard = readCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReadCard() {
        return readCard;
    }

    public void setReadCard(String readCard) {
        this.readCard = readCard;
    }
}
