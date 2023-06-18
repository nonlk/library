package ru.courseProject.library.model;

public class LogPas {

    private String login;
    private String pass;
    private Integer readerId;

    public LogPas() {
    }

    public LogPas(String login, String pass, Integer readerId) {
        this.login = login;
        this.pass = pass;
        this.readerId = readerId;
    }

    public LogPas(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }
}
