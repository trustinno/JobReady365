package com.goldenictsolutions.win.jobready365_.Employee.LanguageHandler;

import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;


import java.util.Locale;

/**
 * Created by Win on 1/11/2017.
 */

public class LanguageHandler {
    Locale myLocale;
   public static  void changeLocale(Resources res, String locale){
        Configuration config;
        config = new Configuration(res.getConfiguration());

        switch (locale){

            case "en":
                config.locale = Locale.ENGLISH;
                break;
            case "my":
                config.locale = new Locale("my");
                break;

            default:
                config.locale = Locale.ENGLISH;
                break;
        }
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

/*

// calling  --------- setLocale("my")

public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, JPolicy.class);
        startActivity(refresh);
    }

 */

}
