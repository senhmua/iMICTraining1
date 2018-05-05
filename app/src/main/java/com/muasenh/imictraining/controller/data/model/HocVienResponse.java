package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by muase on 4/28/2018.
 */

public class HocVienResponse {
    @SerializedName("hocvien")
    @Expose
    public List<Hocvien> hocvien = null;
    @SerializedName("success")
    @Expose
    public Integer success;
    @SerializedName("message")
    @Expose
    public String message;

    public List<Hocvien> getHocvien() {
        return hocvien;
    }

    public Integer getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
