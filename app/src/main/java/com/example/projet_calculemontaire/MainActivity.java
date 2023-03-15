package com.example.projet_calculemontaire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.ParcelCompat;

import android.text.Editable;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAfficher = (Button)findViewById(R.id.button_afficher);

        EditText editText_valeur = (EditText) findViewById(R.id.EditText_Numero);

        TextView text1 = (TextView) findViewById(R.id.textView_resultat1);

        TextView text2 = (TextView) findViewById(R.id.textView_resultat2);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);


        ArrayList<String> Valeurs = new ArrayList<String>();

        Valeurs.add("Dirham");
        Valeurs.add("Dollard");
        Valeurs.add("Euro");


        ArrayAdapter<String> Adapteur = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,Valeurs);
        Adapteur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(Adapteur);


        buttonAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = editText_valeur.getText().toString();

                double numero = Double.parseDouble(str);


                if (spinner.getSelectedItem().toString() == "Dirham")
                {
                    double valeur1;
                    double valeur2;

                    valeur1 = numero * (0.090);
                    valeur2 = numero * (0.097);

                    text1.setText(valeur1 + " Euro");
                    text2.setText(valeur2 + " $");
                }

                if (spinner.getSelectedItem().toString() == "Dollard")
                {
                    double valeur1;
                    double valeur2;

                    valeur1 = numero * (10.35);
                    valeur2 = numero * (0.93);

                    text1.setText(valeur1+ " Dirham");
                    text2.setText(valeur2+ " Euro");
                }
                if (spinner.getSelectedItem().toString() == "Euro")
                {
                    double valeur1;
                    double valeur2;

                    valeur1 = numero * (11.09);
                    valeur2 = numero * (1.07);

                    text1.setText(valeur1+ " Dirham");
                    text2.setText(valeur2+ " $");
                }
            }
        });
    }

}