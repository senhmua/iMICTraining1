package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muase on 4/28/2018.
 */

public class Video {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("tenvideo")
    @Expose
    public String tenvideo;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("makh")
    @Expose
    public String makh;

    public String getId() {
        return id;
    }

    public String getTenvideo() {
        return tenvideo;
    }

    public String getLink() {
        return link;
    }

    public String getMakh() {
        return makh;
    }
}
