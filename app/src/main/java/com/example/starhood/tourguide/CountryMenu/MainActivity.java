package com.example.starhood.tourguide.CountryMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.starhood.tourguide.HolderActivity.AttractionHolder;
import com.example.starhood.tourguide.HolderActivity.HotlesClubs;
import com.example.starhood.tourguide.HolderActivity.NightClubs;
import com.example.starhood.tourguide.R;
import com.example.starhood.tourguide.RecycleView.DividerItemDecoration;
import com.example.starhood.tourguide.RecycleView.RecyclerTouchListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ProvincesData> provinces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       final String category = getIntent().getStringExtra("category");

        //Toast.makeText(this, category, Toast.LENGTH_LONG).show();

        final String Attraction= getResources().getString(R.string.Attraction);
        final String Museums= getResources().getString(R.string.Museums);
        final String NightClubs= getResources().getString(R.string.NightClubs);
        final String Restaurant= getResources().getString(R.string.Restaurant);
        final String Hotels= getResources().getString(R.string.Hotels);


        String Cairo =getResources().getString(R.string.Cairo);
        String Alexandria =getResources().getString(R.string.Alexandria);
        String Aswan =getResources().getString(R.string.Aswan);
        String Luxor =getResources().getString(R.string.Luxor);

        provinces = new ArrayList<ProvincesData>();
        provinces.add(new ProvincesData(Cairo, R.drawable.cairo));
        provinces.add(new ProvincesData(Alexandria, R.drawable.alex));
        provinces.add(new ProvincesData(Aswan, R.drawable.aswan));
        provinces.add(new ProvincesData(Luxor, R.drawable.luxor));

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, provinces);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mLayoutManager.setOrientation(android.support.v7.widget.LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(mLayoutManager);

        //the divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        //onClick Event
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                ProvincesData provincesData = adapter.getItem(position);
                String Location = provincesData.getName();
                Toast.makeText(view.getContext(), Location, Toast.LENGTH_LONG).show();

                Intent intent=null;

                if (category.equals(Attraction)||category.equals(Museums)) {
                    intent = new Intent(view.getContext(), AttractionHolder.class);
                    intent.putExtra("location",Location);
                }
                else if (category.equals(NightClubs)||category.equals(Restaurant)) {
                    intent = new Intent(view.getContext(), NightClubs.class);
                    intent.putExtra("location",Location);
                }
                else{
                    intent = new Intent(view.getContext(), HotlesClubs.class);
                    intent.putExtra("location",Location);

                }

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }


}
