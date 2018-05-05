package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by muase on 4/28/2018.
 */

public class KhoaHoResponse {
    @SerializedName("khoahoc")
    @Expose
    public List<Khoahoc> khoahoc = null;
    @SerializedName("success")
    @Expose
    public Integer success;
    @SerializedName("message")
    @Expose
    public String message;

    public List<Khoahoc> getKhoahoc() {
        return khoahoc;
    }

    public Integer getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
