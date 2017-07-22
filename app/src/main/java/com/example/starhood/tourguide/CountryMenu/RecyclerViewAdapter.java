package com.example.starhood.tourguide.CountryMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.starhood.tourguide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Starhood on 5/10/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Data> {

    private List<ProvincesData> datalist;
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<ProvincesData> datalist) {
        this.datalist = datalist;
        this.mContext = context;
    }
//
    @Override
    public Data onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.provinces_list_item, parent, false);


        Data viewHolder = new Data(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Data holder, int position) {

        ProvincesData dataMember = datalist.get(position);
        holder.imageView.setImageResource(dataMember.getImageID());
        holder.textView.setText(dataMember.getName());
    }

    public ProvincesData getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class Data extends RecyclerView.ViewHolder {
        protected TextView textView;
        protected ImageView imageView;

        public Data(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.province_name);
            this.imageView = (ImageView) itemView.findViewById(R.id.province_im);
        }
    }
}
