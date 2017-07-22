package com.example.starhood.tourguide.HolderActivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.starhood.tourguide.R;
import com.example.starhood.tourguide.RecycleView.DividerItemDecoration;
import com.example.starhood.tourguide.RecycleView.RecyclerTouchListener;

import java.util.ArrayList;

public class AttractionHolder extends AppCompatActivity {

    ArrayList<PreviewData> LuxorpreviewDataList, AswanpreviewDataList, CairopreviewDataList, AlexpreviewDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);


        String Location =getIntent().getStringExtra("location");
        //attraction  luxor
        String [] lu1=getResources().getStringArray(R.array.luxor_attrations1);
        String [] lu2=getResources().getStringArray(R.array.luxor_attrations2);
        String [] lu3=getResources().getStringArray(R.array.luxor_attrations3);
        String [] lu4=getResources().getStringArray(R.array.luxor_attrations4);
        String [] lu5=getResources().getStringArray(R.array.luxor_attrations5);

        LuxorpreviewDataList = new ArrayList<PreviewData>();
        LuxorpreviewDataList.add(new PreviewData(lu1[0],lu1[1],lu1[2],lu1[3], R.drawable.karnak));
        LuxorpreviewDataList.add(new PreviewData(lu2[0],lu2[1],lu2[2],lu2[3], R.drawable.valleyofkings));
        LuxorpreviewDataList.add(new PreviewData(lu3[0],lu3[1],lu3[2],lu3[3], R.drawable.colossi));
        LuxorpreviewDataList.add(new PreviewData(lu4[0],lu4[1],lu4[2],lu4[3], R.drawable.valleyofkings));
        LuxorpreviewDataList.add(new PreviewData(lu5[0],lu5[1],lu5[2],lu5[3], R.drawable.templeofkomombo));


        //attraction Aswan
        String [] as1=getResources().getStringArray(R.array.Aswan_attrations1);
        String [] as2=getResources().getStringArray(R.array.Aswan_attrations2);
        String [] as3=getResources().getStringArray(R.array.Aswan_attrations3);
        String [] as4=getResources().getStringArray(R.array.Aswan_attrations4);
        String [] as5=getResources().getStringArray(R.array.Aswan_attrations5);

        AswanpreviewDataList = new ArrayList<PreviewData>();
        AswanpreviewDataList.add(new PreviewData(as1[0], as1[1], as1[2], as1[3], R.drawable.philae));
        AswanpreviewDataList.add(new PreviewData(as2[0], as2[1], as2[2], as2[3], R.drawable.unfinishedobelisk));
        AswanpreviewDataList.add(new PreviewData(as3[0], as3[1], as3[2], as3[3], R.drawable.nubianmuseum));
        AswanpreviewDataList.add(new PreviewData(as4[0], as4[1], as4[2], as4[3], R.drawable.elephantine));
        AswanpreviewDataList.add(new PreviewData(as5[0], as5[1], as5[2], as5[3], R.drawable.templeofkomombo));

        //attraction alex
        String [] al1=getResources().getStringArray(R.array.Alex_attrations1);
        String [] al2=getResources().getStringArray(R.array.Alex_attrations2);
        String [] al3=getResources().getStringArray(R.array.Alex_attrations3);
        String [] al4=getResources().getStringArray(R.array.Alex_attrations4);
        String [] al5=getResources().getStringArray(R.array.Alex_attrations5);

        AlexpreviewDataList = new ArrayList<PreviewData>();
        AlexpreviewDataList.add(new PreviewData(al1[0],al1[1],al1[2],al1[3], R.drawable.staklahaymanot));
        AlexpreviewDataList.add(new PreviewData(al2[0],al2[1],al2[2],al2[3], R.drawable.citadeloqaitbay));
        AlexpreviewDataList.add(new PreviewData(al3[0],al3[1],al3[2],al3[3], R.drawable.lighthouseofalexandria));
        AlexpreviewDataList.add(new PreviewData(al4[0],al4[1],al4[2],al4[3], R.drawable.romaamphitheatre));
        AlexpreviewDataList.add(new PreviewData(al5[0],al5[1],al5[2],al5[3], R.drawable.staklahaymanot));

        //attration cairo
        String [] ca1=getResources().getStringArray(R.array.Cairo_attrations1);
        String [] ca2=getResources().getStringArray(R.array.Cairo_attrations2);
        String [] ca3=getResources().getStringArray(R.array.Cairo_attrations3);
        String [] ca4=getResources().getStringArray(R.array.Cairo_attrations4);
        String [] ca5=getResources().getStringArray(R.array.Cairo_attrations5);

        CairopreviewDataList = new ArrayList<PreviewData>();
        CairopreviewDataList.add(new PreviewData(ca1[0],ca1[1],ca1[2],ca1[3], R.drawable.khaneli));
        CairopreviewDataList.add(new PreviewData(ca2[0],ca2[1],ca2[2],ca2[3], R.drawable.gizapyramidcomplex));
        CairopreviewDataList.add(new PreviewData(ca3[0],ca3[1],ca3[2],ca3[3], R.drawable.thehangingchurch));
        CairopreviewDataList.add(new PreviewData(ca4[0],ca4[1],ca4[2],ca4[3], R.drawable.islamiccairo));
        CairopreviewDataList.add(new PreviewData(ca5[0],ca5[1],ca5[2],ca5[3], R.drawable.benezrasynagogue));




        // call view
        if(Location.equals("Cairo"))
            initListView(CairopreviewDataList);
        else if (Location.equals("Alexandria"))
            initListView(AlexpreviewDataList);
        else if (Location.equals("Luxor"))
            initListView(LuxorpreviewDataList);
        else if (Location.equals("Aswan"))
            initListView(AswanpreviewDataList);

    }

    void initListView(ArrayList<PreviewData> data) {

        final PreviewAdapter adapter = new PreviewAdapter(this, data);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.holder_recycler_view);

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

                PreviewData previewData = adapter.getItem(position);
                String x = previewData.getUrl();
                Uri location = Uri.parse(x);
                Intent intent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
