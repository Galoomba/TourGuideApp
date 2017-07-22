package com.example.starhood.tourguide.MainMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.starhood.tourguide.CountryMenu.MainActivity;
import com.example.starhood.tourguide.R;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String Attraction= getResources().getString(R.string.Attraction);
        String Museums= getResources().getString(R.string.Museums);
        String NightClubs= getResources().getString(R.string.NightClubs);
        String Restaurant= getResources().getString(R.string.Restaurant);
        String Hotels= getResources().getString(R.string.Hotels);

        final ArrayList<MenuData> data = new ArrayList<MenuData>();
        data.add(new MenuData(Attraction, R.drawable.attractions));
        data.add(new MenuData(Museums, R.drawable.museums));
        data.add(new MenuData(NightClubs, R.drawable.nightclubs));
        data.add(new MenuData(Restaurant, R.drawable.restaurant));
        data.add(new MenuData(Hotels,R.drawable.hotel));

        MenuAdapter menuAdapter=new MenuAdapter(this,data);
        final GridView gridView = (GridView) findViewById(R.id.gv1);
        gridView.setAdapter(menuAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MenuData menuData=(MenuData)parent.getItemAtPosition(position);
                String Selected =menuData.getCaption();

                Intent intent =new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("category",Selected);
                startActivity(intent);
            }
        });
    }
}
