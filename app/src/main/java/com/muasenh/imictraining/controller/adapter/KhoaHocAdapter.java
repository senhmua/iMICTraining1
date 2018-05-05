package com.muasenh.imictraining.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.muasenh.imictraining.R;
import com.muasenh.imictraining.controller.data.model.Khoahoc;

import java.util.List;

/**
 * Created by muase on 4/28/2018.
 */

public class KhoaHocAdapter extends BaseAdapter {

    private Context context;
    private List<Khoahoc> listKh;

    public KhoaHocAdapter(Context context, List<Khoahoc> list) {
        this.context = context;
        this.listKh = list;
    }

    @Override
    public int getCount() {
        return listKh.size();
    }

    @Override
    public Object getItem(int i) {
        return listKh.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder holder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_khoahoc,null);
            holder = new Holder();
            holder.ivIcon = view.findViewById(R.id.iv_icon_kh);
            holder.tvTenKh = view.findViewById(R.id.tv_ten_kh);
            view.setTag(holder);
        }else holder = (Holder) view.getTag();

        Khoahoc khoaHoc = listKh.get(i);
        switch (i){
            case 0:
                holder.ivIcon.setImageResource(R.drawable.ic_home);
                break;
            case 1:
                holder.ivIcon.setImageResource(R.drawable.ic_my_course);
                break;
            case 2:
                holder.ivIcon.setImageResource(R.drawable.ic_java_oracle);
                break;
            case 3:
                holder.ivIcon.setImageResource(R.drawable.ic_android);
                break;
            case 4:
                holder.ivIcon.setImageResource(R.drawable.ic_php);
                break;
            case 5:
                holder.ivIcon.setImageResource(R.drawable.ic_net);
                break;
            case 6:
                holder.ivIcon.setImageResource(R.drawable.ic_j2ee);
                break;
            case 7:
                holder.ivIcon.setImageResource(R.drawable.ic_oracle_database);
                break;
            case 8:
                holder.ivIcon.setImageResource(R.drawable.ic_kotlin);
                break;
            default:
                if(i==listKh.size()-1){
                    holder.ivIcon.setImageResource(R.drawable.ic_logout);
                }else holder.ivIcon.setImageResource(R.drawable.ic_kh_khac);
                break;
        }
        holder.tvTenKh.setText(khoaHoc.getTenkh());
        return view;
    }

    class Holder{
        ImageView ivIcon;
        TextView tvTenKh;
    }
}
