package com.example.webgymglish.controler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.webgymglish.view.FieldAdapter;
import com.example.webgymglish.model.FieldSiteWeb;
import com.example.webgymglish.view.MDToast;
import com.example.webgymglish.R;
import com.example.webgymglish.model.verifInternet;

import java.util.ArrayList;

/**
 * SiteWebActivity class
 *
 * Created by Jean-Christophe THEULIER on 02/07/2019.
 */

public class SiteWebActivity extends AppCompatActivity implements FieldAdapter.OnFieldsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_web);


        //Données contenant les sites
        ArrayList<FieldSiteWeb> fieldSiteWebs = new ArrayList<>();
        FieldAdapter fieldAdapter = new FieldAdapter(fieldSiteWebs, this);
        RecyclerView rcvListeSiteWeb = findViewById(R.id.rcvListeSiteWeb);


        fieldSiteWebs.add (new FieldSiteWeb("Cours en ligne personnalisés",
                "https://www.gymglish.com ",
                "https://www.gymglish.com/fr"));


        fieldSiteWebs.add (new FieldSiteWeb("Cours d'orthographe et expression écrite en français",
                "https://www.frantastique.com", "https://www.frantastique.com/fr/fle"));

        fieldSiteWebs.add (new FieldSiteWeb("Resign, the Word of the month",
                "https://www.thewordofthemonth.com",
                "https://www.thewordofthemonth.com/fr/word/resign"));

        fieldSiteWebs.add (new FieldSiteWeb("La conjugaison des verbes français",
                "https://www.vatefaireconjuguer.com",
                "https://www.vatefaireconjuguer.com"));

        fieldSiteWebs.add (new FieldSiteWeb("Create and market your online course",
                "https://www.gymglish.com/fr/studio",
                "https://www.gymglish.com/fr/studio"));

        fieldSiteWebs.add (new FieldSiteWeb("liste des verbes irréguliers anglais",
                "http://www.anglais-conjugaison.com",
                "http://www.anglais-conjugaison.com/verbe-irregulier"));

        fieldSiteWebs.add (new FieldSiteWeb("Formation d'anglais éligible au CPF",
                "https://www.anglais-cpf.fr",
                "https://www.anglais-cpf.fr"));

        fieldAdapter.notifyDataSetChanged();

        rcvListeSiteWeb.setLayoutManager(new LinearLayoutManager(null));
        rcvListeSiteWeb.setAdapter(fieldAdapter);
    }

    @Override
    public void onClick(FieldSiteWeb fieldSiteWebs) {

        if (new verifInternet().isConnectedNetwork (getApplicationContext()) ) {
            Intent intent = new Intent(SiteWebActivity.this, PageWebActivity.class);
            //                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
            //                       Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("URL_WEB", fieldSiteWebs.getUrl_long());

            startActivity(intent);
        } else {
            MDToast.makeText(getApplicationContext(),
                    "Réseau internet non disponible",
                    MDToast.LENGTH_SHORT,
                    MDToast.TYPE_WARNING).show();
        }

    }
}
