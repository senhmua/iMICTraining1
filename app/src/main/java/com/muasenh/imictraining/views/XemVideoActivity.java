package com.muasenh.imictraining.views;
/*từ activity video khoá học sang
*xem video-co mạng, mất mạng - hien tên video và coment
*coment duoc day len server, mat mang se duoc luu lai local, co mang tro lai se tu dong cap nhap
*/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.muasenh.imictraining.R;

public class XemVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_video);
    }
}
