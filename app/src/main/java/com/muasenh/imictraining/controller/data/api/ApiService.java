package com.muasenh.imictraining.controller.data.api;

import com.muasenh.imictraining.controller.data.model.CommentResponse;
import com.muasenh.imictraining.controller.data.model.HocVienResponse;
import com.muasenh.imictraining.controller.data.model.InsertCommentResponse;
import com.muasenh.imictraining.controller.data.model.KhoaHoResponse;
import com.muasenh.imictraining.controller.data.model.LopResponse;
import com.muasenh.imictraining.controller.data.model.UserResponse;
import com.muasenh.imictraining.controller.data.model.VideoResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by muase on 4/28/2018.
 */

public interface ApiService {

    @GET("get_all_user.php")
    Call<UserResponse> getAllUser();

    @GET("get_all_hocvien.php")
    Call<HocVienResponse> getAllHocvien();

    @GET("get_all_khoahoc.php")
    Call<KhoaHoResponse> getAllKhoahoc();

    @GET("get_all_lop.php")
    Call<LopResponse> getAllLop();

    @GET("get_all_video.php")
    Call<VideoResponse> getAllVideo();

    @GET("get_all_comment.php")
    Call<CommentResponse> getAllComment();

    @FormUrlEncoded
    @POST
    Call<InsertCommentResponse> insertComment(@Field("noidung") String noidung,
                                              @Field("mahv") String mahv,
                                              @Field("idvd") String idvd);
}
