package ru.courseProject.library.model;

public class LogPas {

    private String login;
    private String password;
    private Integer readerId;

    public LogPas() {
    }

    public LogPas(String login, String password, Integer readerId) {
        this.login = login;
        this.password = password;
        this.readerId = readerId;
    }

    public LogPas(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }
}
