package com.example.fpolylib.model;

public class NguoiDung {
    private int mauser;
    private String username;
    private String password;

    public NguoiDung(int mauser, String username, String password) {
        this.mauser = mauser;
        this.username = username;
        this.password = password;
    }

    public int getMauser() {
        return mauser;
    }

    public void setMauser(int mauser) {
        this.mauser = mauser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
