package com.example.starhood.tourguide.HolderActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.starhood.tourguide.R;
import com.example.starhood.tourguide.RecycleView.DividerItemDecoration;
import com.example.starhood.tourguide.RecycleView.RecyclerTouchListener;

import java.util.ArrayList;

public class HotlesClubs extends AppCompatActivity {

    ArrayList<PreviewData> LuxorpreviewDataList, AswanpreviewDataList, CairopreviewDataList, AlexpreviewDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);


        String Location =getIntent().getStringExtra("location");


        String []lu1=getResources().getStringArray(R.array.Luxor_hotle1);
        String []lu2=getResources().getStringArray(R.array.Luxor_hotle2);
        String []as1=getResources().getStringArray(R.array.Aswan_hotle1);
        String []as2=getResources().getStringArray(R.array.Aswan_hotle2);
        String []al1=getResources().getStringArray(R.array.Alex_hotle1);
        String []al2=getResources().getStringArray(R.array.Alex_hotle2);
        String []ca1=getResources().getStringArray(R.array.Cairo_hotle1);
        String []ca2=getResources().getStringArray(R.array.Cairo_hotle2);

        LuxorpreviewDataList = new ArrayList<PreviewData>();
        LuxorpreviewDataList.add(new PreviewData(lu1[0],lu1[1],lu1[2],lu1[3], R.drawable.staklahaymanot));
        LuxorpreviewDataList.add(new PreviewData(lu2[0],lu2[1],lu2[2],lu2[3], R.drawable.pavillon));


        AswanpreviewDataList = new ArrayList<PreviewData>();
        AswanpreviewDataList.add(new PreviewData(as1[0],as1[1],as1[2],as1[3], R.drawable.amoon));
        AswanpreviewDataList.add(new PreviewData(as2[0],as2[1],as2[2],as2[3], R.drawable.basma));


        AlexpreviewDataList = new ArrayList<PreviewData>();
        AlexpreviewDataList.add(new PreviewData(al1[0],al1[1],al1[2],al1[3], R.drawable.hilton));
        AlexpreviewDataList.add(new PreviewData(al2[0],al2[1],al2[2],al2[3], R.drawable.four));


        CairopreviewDataList = new ArrayList<PreviewData>();
        CairopreviewDataList.add(new PreviewData(ca1[0],ca1[1],ca1[2],ca1[3], R.drawable.barcelo));
        CairopreviewDataList.add(new PreviewData(ca2[0],ca2[1],ca2[2],ca2[3], R.drawable.helnan));




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
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

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
