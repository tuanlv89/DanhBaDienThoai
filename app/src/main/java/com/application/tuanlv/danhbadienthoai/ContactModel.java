package com.application.tuanlv.danhbadienthoai;

import android.graphics.Bitmap;

public class ContactModel {
    private String name;
    private String number;
    private Bitmap avatar;

    public ContactModel(String name, String number, Bitmap avatar) {
        this.name = name;
        this.number = number;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }
}
