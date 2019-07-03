package com.example.webgymglish.controler;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.webgymglish.view.MDToast;
import com.example.webgymglish.R;
import com.example.webgymglish.model.verifInternet;

/**
 * MainActivity class
 *
 * Created by Jean-Christophe THEULIER on 02/07/2019.
 */


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnSeconnecter = findViewById(R.id.btnSeConnecter);
        btnSeconnecter.setOnClickListener(v -> {

            EditText edtlogin = findViewById(R.id.edtLogin);
            EditText edtPassword = findViewById(R.id.edtPasword);

            String login = edtlogin.getText().toString();
            String  password  = edtPassword.getText().toString();

            // vérifier la saisie
            if (login.equals("user") && password.equals("password") ) {

                // vérifie connexion internet
                if (new verifInternet().isConnectedNetwork (getApplicationContext()) ){
                    Intent intent = new Intent(MainActivity.this, SiteWebActivity.class);
                                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                          Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();

                } else { // Pas de reseau
                    MDToast.makeText(getApplicationContext(),
                            getString(R.string.reseau_non_dispo),
                            MDToast.LENGTH_SHORT,
                            MDToast.TYPE_WARNING).show();
                }


            } else { // erreur de saisie
                MDToast.makeText(getApplicationContext(),
                        getString(R.string.erreur_saisie),
                        MDToast.LENGTH_SHORT,
                        MDToast.TYPE_WARNING).show();
            }
        });
    }
}
