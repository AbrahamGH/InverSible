package com.example.inversible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class resultaInversion extends AppCompatActivity {
    TextView txtInverison,txtGanancia,txtPlazo,txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resulta_inversion);
        txtInverison = findViewById(R.id.txtInverison);
        txtGanancia = findViewById(R.id.txtGanancia);
        txtPlazo = findViewById(R.id.txtPlazo);
        txtTotal = findViewById(R.id.txtTotal);

        calculo();
    }

    private void calculo() {
        Float m = Float.valueOf(getIntent().getStringExtra("monto"));
        Float p = Float.valueOf(getIntent().getStringExtra("porcentaje"));
        Integer d = Integer.valueOf(getIntent().getStringExtra("duracion"));
        Float porcentaje = (float)p/100;//extraer valor en porcentaje
        Float dato1 = m*(porcentaje/12)*d;//extraer la invercion total plazo fijo
        Float suma = Float.valueOf(0);
        DecimalFormat df = new DecimalFormat("#.00");
        Float desgloce = dato1/d;
        for (int i=0;i<d;i++){
            suma= suma+desgloce;
            Log.d("porcentaje " + i,df.format(suma));
            Float total= m + suma;
            Log.d("inversion total " + i,df.format(total));
        }
        txtGanancia.setText(df.format(m));
        txtInverison.setText(df.format(m + dato1));
        txtTotal.setText( df.format(suma));
        txtPlazo.setText(d.toString()+" meses");
    }
}