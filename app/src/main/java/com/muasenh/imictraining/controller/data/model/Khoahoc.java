package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muase on 4/28/2018.
 */

public class Khoahoc {
    @SerializedName("makh")
    @Expose
    public String makh;
    @SerializedName("tenkh")
    @Expose
    public String tenkh;

    public Khoahoc(String makh, String tenkh) {
        this.makh = makh;
        this.tenkh = tenkh;
    }

    public String getMakh() {
        return makh;
    }

    public String getTenkh() {
        return tenkh;
    }
}
