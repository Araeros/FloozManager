package com.floozmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class ParameterActivity extends AppCompatActivity {

    private Button mResetBtn;
    private ImageButton mHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameter);

        mResetBtn = findViewById(R.id.activity_parameter_reset_btn);
        mHomeBtn = findViewById(R.id.logo_btn);

        mHomeBtn.setOnClickListener(v -> {
            Intent mainActivity = new Intent(ParameterActivity.this, MainActivity.class);
            startActivity(mainActivity);
        });

        mResetBtn.setOnClickListener(v -> {
            //TODO Ajouter le comportement à effectuer (Reset de la bdd)
        });
    }
}