package com.muasenh.imictraining.views;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;


import com.muasenh.imictraining.R;
import com.muasenh.imictraining.controller.adapter.KhoaHocAdapter;
import com.muasenh.imictraining.controller.data.api.ApiService;
import com.muasenh.imictraining.controller.data.api.RetrofitClient;
import com.muasenh.imictraining.controller.data.model.KhoaHoResponse;
import com.muasenh.imictraining.controller.data.model.Khoahoc;
import com.muasenh.imictraining.controller.data.model.User;
import com.muasenh.imictraining.controller.until.Constan;
import com.muasenh.imictraining.views.fragment.DSLopHocFragment;
import com.muasenh.imictraining.views.fragment.HomeFragment;
import com.muasenh.imictraining.views.fragment.KhoaHocCuaToiFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private android.support.v4.app.FragmentManager fragmentManager;
    private FrameLayout frameLayout;
    private List<Khoahoc> navigationList;
    private ListView lvKhoaHoc;

    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        lvKhoaHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        replaceFragment(new HomeFragment());
                        break;
                    case 1:
                        replaceFragment(new KhoaHocCuaToiFragment());
                        break;
                    default:
                        replaceFragment(new DSLopHocFragment());
                        break;
                }
                drawerLayout.closeDrawers();
            }
        });
    }

    private void initData() {
        setSupportActionBar(toolbar);
        toolbar.setTitle("IMICROSOFT EDUCATION");
        toolbar.setSubtitle("Khởi nguồn cho thành công của bạn");

        setSupportActionBar(toolbar);  // add toolbar thành actionbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //set icon hiển thị

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        replaceFragment(new HomeFragment());

        navigationList = new ArrayList<>();

        //lay thong tin khoa hoc tu servise
        RetrofitClient.getClient(Constan.API_URL).create(ApiService.class)
                .getAllKhoahoc().enqueue(new Callback<KhoaHoResponse>() {
            @Override
            public void onResponse(Call<KhoaHoResponse> call, Response<KhoaHoResponse> response) {
                KhoaHoResponse khoaHoResponse = response.body();
                navigationList.add(new Khoahoc("0","Trang chủ"));
                navigationList.add(new Khoahoc("0","Khoá học của tôi"));
                for(int i = 0; i <khoaHoResponse.getKhoahoc().size();i++){
                    navigationList.add(khoaHoResponse.getKhoahoc().get(i));
                }
                navigationList.add(new Khoahoc("0","Đăng xuất"));
                KhoaHocAdapter adapter = new KhoaHocAdapter(MainActivity.this,navigationList);
                lvKhoaHoc.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<KhoaHoResponse> call, Throwable t) {
                Log.d("eee", "onFailure: " + t.toString());
            }
        });

        //Nhận user từ login sang truyền sang fragment khoá họcuarua tôi
        user = (User) getIntent().getSerializableExtra(Constan.KEY_USER);
    }

    private void initView() {
        toolbar = findViewById(R.id.tool_bar);
        navigationView = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.dr_layout);
        frameLayout = findViewById(R.id.frame_layout);
        lvKhoaHoc = findViewById(R.id.lv_nv_khoahoc);
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame_layout,fragment);
        ft.commit();
    }
}
