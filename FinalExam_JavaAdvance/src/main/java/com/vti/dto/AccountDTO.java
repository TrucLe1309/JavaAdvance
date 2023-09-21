package com.vti.dto;

public class AccountDTO {
    private int id;
    private String username;

    public AccountDTO() {
    }

    public AccountDTO(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }
}
