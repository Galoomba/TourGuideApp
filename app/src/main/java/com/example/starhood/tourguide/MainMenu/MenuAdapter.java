package com.example.starhood.tourguide.MainMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.starhood.tourguide.R;

import java.util.ArrayList;

/**
 * Created by Starhood on 5/30/17.
 */

public class MenuAdapter extends ArrayAdapter<MenuData> {

    public MenuAdapter(Context context, ArrayList<MenuData> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View list;
        list = convertView;

        if(list == null) {
            list = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_list_item, parent, false);
        }

        MenuData current = getItem(position);


        TextView caption = (TextView) list.findViewById(R.id.menu_text);
        caption.setText(current.getCaption());


        ImageView iconView = (ImageView) list.findViewById(R.id.menu_item);
        iconView.setImageResource(current.getImageID());


        return list;
    }
}
