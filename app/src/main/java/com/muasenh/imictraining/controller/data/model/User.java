package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by muase on 4/28/2018.
 */

public class User implements Serializable{
    @SerializedName("mahv")
    @Expose
    public String mahv;
    @SerializedName("user")
    @Expose
    public String user;
    @SerializedName("pass")
    @Expose
    public String pass;



    public String getMahv() {
        return mahv;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
