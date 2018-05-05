package com.muasenh.imictraining.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muasenh.imictraining.R;
import com.muasenh.imictraining.controller.data.api.ApiService;
import com.muasenh.imictraining.controller.data.api.RetrofitClient;
import com.muasenh.imictraining.controller.data.model.User;
import com.muasenh.imictraining.controller.data.model.UserResponse;
import com.muasenh.imictraining.controller.until.Constan;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView btnLogin, tvQuenMk;
    private EditText edtUser, edtPass;
    private CheckBox cbRemenber;

    private String user;
    private String pass;
    private boolean remenber = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        iniEvent();

        initData();
    }

    private void initData() {
        getUser();
        if (remenber) {
            cbRemenber.setChecked(true);
            edtUser.setText(user);
            edtPass.setText(pass);
        }
    }

    private void iniEvent() {
        btnLogin.setOnClickListener(this);
    }

    private void initView() {
        btnLogin = findViewById(R.id.btn_login);
        edtUser = findViewById(R.id.edt_user);
        edtPass = findViewById(R.id.edt_pass);
        tvQuenMk = findViewById(R.id.tv_quenmk);
        cbRemenber = findViewById(R.id.cb_remenber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                xulyLogin();
                break;
            case R.id.tv_quenmk:

                break;
        }
    }

    private void xulyLogin() {
        user = edtUser.getText().toString().trim();
        pass = edtPass.getText().toString().trim();
        if (!user.isEmpty() && !pass.isEmpty())
            RetrofitClient.getClient(Constan.API_URL).create(ApiService.class)
                    .getAllUser().enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    UserResponse userResponse = response.body();
                    boolean check = false;
                    User user1 = null;
                    for (int i = 0; i < userResponse.getUsers().size(); i++) {
                        if (user.equals(userResponse.getUsers().get(i).getUser()) &&
                                pass.equalsIgnoreCase(userResponse.getUsers().get(i).getPass())) {
                            user1 = userResponse.getUsers().get(i);
                            check = true;
                            continue;
                        }
                    }
                    if (check && user1 != null) {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra(Constan.KEY_USER, user1);
                        startActivity(intent);
                        finish();
                        if (cbRemenber.isChecked()) {
                            Log.d("aaa", "xuly Luu Taikhoan: ");
                            xulyLuuTaikhoan();
                        } else {
                            Log.d("aaa", "xuly Xoa LuuTaiKhoan: ");
                            xulyXoaLuuTaiKhoan();
                        }
                    } else
                        Toast.makeText(LoginActivity.this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    Log.d("aaa", "onFailure: " + t.toString());
                }
            });
    }

    private void xulyXoaLuuTaiKhoan() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constan.FILE_USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(Constan.KEY_USER);
        editor.remove(Constan.KEY_PASS);
        editor.remove(Constan.KEY_SAVE);
        editor.commit();
    }

    private void xulyLuuTaikhoan() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constan.FILE_USER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constan.KEY_USER, user);
        editor.putString(Constan.KEY_PASS, pass);
        editor.putBoolean(Constan.KEY_SAVE, true);
        editor.commit();
    }

    private void getUser() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constan.FILE_USER, MODE_PRIVATE);
        user = sharedPreferences.getString(Constan.KEY_USER, "");
        pass = sharedPreferences.getString(Constan.KEY_PASS, "");
        remenber = sharedPreferences.getBoolean(Constan.KEY_SAVE, false);
    }
}
