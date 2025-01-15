package com.example.fpolylib.model;

public class Sach {
    private int masach;
    private String tensach;

    public Sach(int masach, String tensach) {
        this.masach = masach;
        this.tensach = tensach;
    }

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }
}
