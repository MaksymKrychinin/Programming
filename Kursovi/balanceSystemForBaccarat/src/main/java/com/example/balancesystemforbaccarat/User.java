package com.example.balancesystemforbaccarat;

import java.util.Objects;

public class User {
    String login;
    int balance;
    int red;
    int blue;
    int tie;

    public User(String login, int balance) {
        this.login = login;
        this.balance = balance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    void clear() {
        blue = 0;
        red = 0;
        tie = 0;
    }

    public void winBlue() {
        balance += blue * 2;
        clear();
    }

    public void winTie() {
        balance += blue;
        balance += red;
        balance += tie * 8;
        clear();
    }

    public void winRed() {
        balance += red * 2;
        clear();
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
