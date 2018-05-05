package com.muasenh.imictraining.controller.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muase on 4/28/2018.
 */

public class InsertCommentResponse {
    @SerializedName("success")
    @Expose
    public Integer success;
    @SerializedName("message")
    @Expose
    public String message;

    public Integer getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
