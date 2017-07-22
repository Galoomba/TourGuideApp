package com.example.starhood.tourguide.MainMenu;

/**
 * Created by Starhood on 5/30/17.
 */

public class MenuData {
    private int imageID;
    private String caption;

    public MenuData (String caption,int imageID)
    {
        this.caption=caption;
        this.imageID=imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public String getCaption() {
        return caption;
    }
}
