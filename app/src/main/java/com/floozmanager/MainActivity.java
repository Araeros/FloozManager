package com.floozmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import Data.DatabaseManager;

public class MainActivity extends AppCompatActivity {



    private TextView mBienvenuTxt;
    private EditText mValEntree;
    private Button mCalculerBtn;
    private TextView mCalTxt;
    private TextView mDepTxt;
    private TextView mGainTxt;
    private TextView mAffCalTxt;
    private TextView mAffGainTxt;
    private TextView mAffDepTxt;
    private TextView mAffLog;
    private TextView mAffRes;
    private ImageButton mParamBtn;

    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Lien entre les éléments Graphique et notre main
        mBienvenuTxt = findViewById(R.id.activity_main_bienvenu_txt);
        mValEntree = findViewById(R.id.activity_main_val_entree);
        mValEntree.setKeyListener(DigitsKeyListener.getInstance("0123456789.-"));
        mCalculerBtn = findViewById(R.id.activity_main_calculer_btn);
        mCalTxt = findViewById(R.id.activity_main_cal_txt);
        mDepTxt = findViewById(R.id.activity_main_depenses_txt);
        mGainTxt = findViewById(R.id.activity_main_gain_txt);
        mAffCalTxt = findViewById(R.id.activity_main_affiche_cal_txt);
        mAffGainTxt = findViewById(R.id.activity_main_affiche_gain_txt);
        mAffDepTxt = findViewById(R.id.activity_main_affiche_depenses_txt);
        mAffLog = findViewById(R.id.activity_main_affiche_log);
        mAffRes = findViewById(R.id.activity_main_affiche_resultats);
        mParamBtn = findViewById(R.id.activity_main_parameter_btn);

        //Variable
        Resultats resultats = new Resultats();
        LogText logsTest = new LogText();
        databaseManager = new DatabaseManager(this);

        //Désactivation du bouton avant saisie
        mCalculerBtn.setEnabled(false);

        //Comportement de l'application lors du click surle bouton Paramètres
        mParamBtn.setOnClickListener(v -> {
            Intent parameterActivity = new Intent(MainActivity.this, ParameterActivity.class);
            startActivity(parameterActivity);
        });

        //Comportement de l'application lors de la saisie d'un texte
        mValEntree.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCalculerBtn.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Comportement de l'application lors du click sur le bouton Calculer
        mCalculerBtn.setOnClickListener(v -> {
            //L'utilisateur vient de cliquer sur le bouton
            EntryString entree = new EntryString(mValEntree.getText().toString());
            logsTest.concat(entree.toDecimal().toString());

            if (entree.testDecimal()) {
                resultats.calculerPerte(entree);
            } else {
                resultats.calculerChiffreAffaire(entree);
            }
            resultats.calculerBenefice();
            logsTest.concat(resultats.toString());

            //Mise à jour de la vue
            mCalTxt.setText(resultats.toStringChiffreAffaire());
            mDepTxt.setText(resultats.toStringPerte());
            mGainTxt.setText(resultats.toStringBenefice());
            mValEntree.setText("");
            mAffLog.setText(logsTest.toString());

            //Comportement de la BDD
            databaseManager.insertResultat(resultats);
            databaseManager.close();

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}