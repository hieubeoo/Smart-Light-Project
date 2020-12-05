package com.example.project;

public class device {
    private String ten;
    private int image;

    public device(){};
    public device(String ten, int image) {
        this.ten = ten;
        this.image = image;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
