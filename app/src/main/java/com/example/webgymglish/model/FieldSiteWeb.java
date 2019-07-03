package com.example.webgymglish.model;

/**
 * FieldSiteWeb class
 *
 * Created by Jean-Christophe THEULIER on 02/07/2019.
 */
public class FieldSiteWeb {
    private String descriptif;
    private String url_court;
    private String url_long;


    public FieldSiteWeb(String descriptif, String url_court, String url_long) {
        this.descriptif = descriptif;
        this.url_court = url_court;
        this.url_long = url_long;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public String getUrl_court() {
        return url_court;
    }


    public String getUrl_long() {
        return url_long;
    }

}
