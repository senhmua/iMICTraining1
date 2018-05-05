package com.muasenh.imictraining.views.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.muasenh.imictraining.R;
import com.muasenh.imictraining.controller.data.api.ApiService;
import com.muasenh.imictraining.controller.data.api.RetrofitClient;
import com.muasenh.imictraining.controller.data.model.KhoaHoResponse;
import com.muasenh.imictraining.controller.data.model.Khoahoc;
import com.muasenh.imictraining.controller.until.Constan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class KhoaHocCuaToiFragment extends Fragment {


    private ListView lvKhoahocuatoi;
    private LinearLayout llTrong;

    private List<Khoahoc> listKhCuatoi;

    public KhoaHocCuaToiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_khoa_hoc_cua_toi, container, false);
        initView(view);
        initData();
        // Inflate the layout for this fragment
        return view;
    }

    private void initData() {
        RetrofitClient.getClient(Constan.API_URL).create(ApiService.class)
                .getAllKhoahoc().enqueue(new Callback<KhoaHoResponse>() {
            @Override
            public void onResponse(Call<KhoaHoResponse> call, Response<KhoaHoResponse> response) {

            }

            @Override
            public void onFailure(Call<KhoaHoResponse> call, Throwable t) {

            }
        });
    }

    private void initView(View view) {
        lvKhoahocuatoi = view.findViewById(R.id.lv_kh_cuatoi);
        llTrong = view.findViewById(R.id.ll_trong);
    }

}
