package com.example.starhood.tourguide.HolderActivity;

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
 * Created by Starhood on 5/30/17.
 */


public class PreviewAdapter extends RecyclerView.Adapter<PreviewAdapter.Data> {

    private List<PreviewData> datalist;
    private Context mContext;

    public PreviewAdapter(Context context, ArrayList<PreviewData> datalist) {
        this.datalist = datalist;
        this.mContext = context;
    }
    //
    @Override
    public PreviewAdapter.Data onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.holder_list_item, parent, false);


        PreviewAdapter.Data viewHolder = new PreviewAdapter.Data(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PreviewAdapter.Data holder, int position) {

        PreviewData dataMember = datalist.get(position);
        holder.imageView.setImageResource(dataMember.getImageID());
        holder.name.setText(dataMember.getName());
        holder.rate.setText(dataMember.getRate());
        holder.des.setText(dataMember.getDes());
    }

    public PreviewData getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class Data extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView rate;
        protected TextView des;
        protected ImageView imageView;

        public Data(View itemView) {
            super(itemView);

            this.name = (TextView) itemView.findViewById(R.id.name);
            this.rate = (TextView) itemView.findViewById(R.id.rating);
            this.des = (TextView) itemView.findViewById(R.id.description);
            this.imageView = (ImageView) itemView.findViewById(R.id.kimg);
        }
    }
}
