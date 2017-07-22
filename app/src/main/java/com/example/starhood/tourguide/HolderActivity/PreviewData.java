package com.example.starhood.tourguide.HolderActivity;

import java.net.URL;

/**
 * Created by Starhood on 5/30/17.
 */

public class PreviewData {
    private int imageID;
    private String name;
    private String rate;
    private String des;
    private String url;

    public PreviewData(String name,String rate,String des,String url,int imageID){
        this.imageID=imageID;
        this.name=name;
        this.rate=rate;
        this.des=des;
        this.url=url;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public String getRate() {
        return rate;
    }

    public String getDes() {
        return des;
    }

    public String getUrl() {
        return url;
    }
}
