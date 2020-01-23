package com.example.ventanasdialogo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnV_Mensaje;
    private Button btnV_Botones;
    private static final int DIALOGO_MENSAJE = 1;
    private static final int DIALOGO_BOTONES = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnV_Mensaje = findViewById(R.id.btnV_Mensaje);
        btnV_Botones = findViewById(R.id.btnV_Botones);

        btnV_Mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressWarnings("deprecation")
            public void onClick(View v) {
                showDialog(DIALOGO_MENSAJE);
            }
        });

        btnV_Botones.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressWarnings("deprecation")
            public void onClick(View v) {
                showDialog(DIALOGO_BOTONES);
            }
        });
    }

    @Override
    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        switch(id){
            case DIALOGO_MENSAJE:
                ad.setTitle("Atención");
                ad.setMessage("Esto es un mensaje. Pulsa atras para cerrar");
                ad.setIcon(android.R.drawable.ic_dialog_alert);
                break;
            case DIALOGO_BOTONES:
                ad.setTitle("Atención");
                ad.setMessage("Esto es un mensaje. Pulsa el boton OK para volver");
                ad.setIcon(android.R.drawable.ic_dialog_alert);
                ad.setCancelable(false);
                ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    @TargetApi(16) //Suprime los errores de correspondencia de API (NO IMPIDE LA EJECUCIÓN EN API INFERIOR)
                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
                        finishAffinity(); //Cierra la pila (A PARTIR DE LA API 16)
                    }
                });
                break;
        }
        return ad.create();
    }
}
