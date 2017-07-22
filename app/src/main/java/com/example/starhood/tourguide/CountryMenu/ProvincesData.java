package com.example.starhood.tourguide.CountryMenu;

/**
 * Created by Starhood on 5/10/17.
 */

public class ProvincesData {
    private int imageID;
    private String name;

    public ProvincesData(String name,int imageID){
        this.imageID=imageID;
        this.name=name;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }
}
