package com.floozmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
import com.fabernovel.d3library.D3Drawable;
import com.fabernovel.d3library.D3View;
import com.fabernovel.d3library.arc.D3Arc;
import com.fabernovel.d3library.axes.D3FloatFunction;
*/


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
    //private D3View mGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Lien entre les éléments Graphique et notre main
        mBienvenuTxt = findViewById(R.id.activity_main_bienvenu_txt);
        mValEntree = findViewById(R.id.activity_main_val_entree);
        mCalculerBtn = findViewById(R.id.activity_main_calculer_btn);
        mCalTxt = findViewById(R.id.activity_main_cal_txt);
        mDepTxt = findViewById(R.id.activity_main_depenses_txt);
        mGainTxt = findViewById(R.id.activity_main_gain_txt);
        mAffCalTxt = findViewById(R.id.activity_main_affiche_cal_txt);
        mAffGainTxt = findViewById(R.id.activity_main_affiche_gain_txt);
        mAffDepTxt = findViewById(R.id.activity_main_affiche_depenses_txt);

        //Liens pour le graph
        //mGraph = (D3View) findViewById(R.id.activity_main_graph);

        //Variable
        Resultats resultats = new Resultats();

        //Désactivation du bouton avant saisie
        mCalculerBtn.setEnabled(false);

        //Gestion du graphique
        //Gérer le graphique pour un affichage des résultats simple et élégant
        //Le graphique ne se met pas à jour
        /*
        //[0] : chiffreAffaire, [1] : pertes
        Decimal[] data = resultats.getTableau2Elements();
        float[] poids = {1,1};

        final D3Arc<Decimal> arc = new D3Arc<>(data);
        arc.weights(poids);
        arc.offsetX(1);
        arc.offsetY(1);
        arc.innerRadius(250);
        arc.outerRadius(300);
        arc.padAngle(0);
        arc.colors(new int[]{
                0xFFCD7F32, 0xFFFFD700
        });
        arc.labels(new String[]{"Chiffre d'affaire", "Dépenses"});
        mGraph.add(arc);
        */


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

        //Comportement de l'application lors du click sur le bouton
        //Les chiffres à virgules ne sont pas gérés
        mCalculerBtn.setOnClickListener(v -> {
            //L'utilisateur vient de cliquer sur le bouton
            if (Integer.parseInt(mValEntree.getText().toString()) < 0) {
                resultats.calculerPerte(Integer.parseInt(mValEntree.getText().toString()));
            } else {
                resultats.calculerChiffreAffaire(Integer.parseInt(mValEntree.getText().toString()));
            }
            resultats.calculerBenefice();
            mCalTxt.setText(resultats.toStringChiffreAffaire());
            mDepTxt.setText(resultats.toStringPerte());
            mGainTxt.setText(resultats.toStringBenefice());

            //Gestion du graphique
            /*
            Decimal[] données = resultats.getTableau2Elements();
            float[] ratio = resultats.getRatio();

            arc.weights(ratio);
            Log.d("MainActivity","Poids : [0]"+poids[0]+", [1] "+poids[1]);
            arc.offsetX(1);
            arc.offsetY(1);
            arc.innerRadius(250);
            arc.outerRadius(300);
            arc.padAngle(0);
            arc.colors(new int[]{
                    0xFFCD7F32, 0xFFFFD700
            });
            arc.labels(new String[]{"Chiffre d'affaire", "Dépenses"});
            mGraph.add(arc);
            */

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