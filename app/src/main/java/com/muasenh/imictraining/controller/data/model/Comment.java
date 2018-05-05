package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by muase on 4/28/2018.
 */

public class Comment {
    @SerializedName("idcm")
    @Expose
    public String idcm;
    @SerializedName("noidung")
    @Expose
    public String noidung;
    @SerializedName("mahv")
    @Expose
    public String mahv;
    @SerializedName("idvd")
    @Expose
    public String idvd;

    public String getIdcm() {
        return idcm;
    }

    public String getNoidung() {
        return noidung;
    }

    public String getMahv() {
        return mahv;
    }

    public String getIdvd() {
        return idvd;
    }
}
