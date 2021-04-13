package com.example.inversible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;

import static com.example.inversible.R.string.samsung;

public class InverSible extends AppCompatActivity {
    EditText edtMonto, edtPorcentaje, edtDuracion;
    Button btnCalculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inver_sible);
        edtMonto = findViewById(R.id.edtMonto);

        edtPorcentaje = findViewById(R.id.edtPorcentaje);
        edtDuracion = findViewById(R.id.edtDuracion);
        btnCalculo = findViewById(R.id.btnCalculo);
        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        String monto = edtMonto.getText().toString();
        String porcentaje = edtPorcentaje.getText().toString();
        String duracion = edtDuracion.getText().toString();
        if (TextUtils.isEmpty(monto) || TextUtils.isEmpty(porcentaje) || TextUtils.isEmpty(duracion)) {
            Toast.makeText(this, "No se aceptan campos vacios", Toast.LENGTH_SHORT).show();
        }else {
            Intent datos = new Intent(InverSible.this, resultaInversion.class);
            datos.putExtra("monto", edtMonto.getText().toString());
            datos.putExtra("porcentaje", edtPorcentaje.getText().toString());
            datos.putExtra("duracion", edtDuracion.getText().toString());
            startActivity(datos);

        }

    }
}