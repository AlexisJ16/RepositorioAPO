package model;

import java.time.LocalDate;

public abstract class User {

    private String nickname;
    private int id;
    private LocalDate dateOfAffiliation;

    public User(String nickname, int id, LocalDate dateOfAffiliation) {
        this.nickname = nickname;
        this.id = id;
        this.dateOfAffiliation = dateOfAffiliation;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateOfAffiliation() {
        return dateOfAffiliation;
    }

    public void setDateOfAffiliation(LocalDate dateOfAffiliation) {
        this.dateOfAffiliation = dateOfAffiliation;
    }

    @Override
    public String toString() {
        return "User [nickname=" + nickname + ", id=" + id + ", dateOfAffiliation=" + dateOfAffiliation + "]";
    }

}