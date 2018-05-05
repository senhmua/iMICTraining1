package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muase on 4/28/2018.
 */

public class Hocvien {
    @SerializedName("mahv")
    @Expose
    public String mahv;
    @SerializedName("hoten")
    @Expose
    public String hoten;
    @SerializedName("sdt")
    @Expose
    public String sdt;
    @SerializedName("tuoi")
    @Expose
    public String tuoi;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("malop")
    @Expose
    public String malop;
    @SerializedName("makh")
    @Expose
    public String makh;

    public String getMahv() {
        return mahv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getTuoi() {
        return tuoi;
    }

    public String getEmail() {
        return email;
    }

    public String getMalop() {
        return malop;
    }

    public String getMakh() {
        return makh;
    }
}
