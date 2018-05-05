package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muase on 4/28/2018.
 */

public class Lop {
    @SerializedName("malop")
    @Expose
    public String malop;
    @SerializedName("tenlop")
    @Expose
    public String tenlop;
    @SerializedName("ngaykhaigiang")
    @Expose
    public String ngaykhaigiang;
    @SerializedName("giangvien")
    @Expose
    public String giangvien;
    @SerializedName("makh")
    @Expose
    public String makh;

    public String getMalop() {
        return malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public String getNgaykhaigiang() {
        return ngaykhaigiang;
    }

    public String getGiangvien() {
        return giangvien;
    }

    public String getMakh() {
        return makh;
    }
}
