package com.cavanosa.tutorialmemory;

import static com.cavanosa.tutorialmemory.R.string.validacion_usuario;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play, salir;
    EditText etUsername;

    private static final int CODIGO_PARA_INICIAR_JUEGO = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.botonMainJugar);
        salir = findViewById(R.id.botonMainSalir);
        etUsername = findViewById(R.id.textViewUsuario);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle enviarUsuario = new Bundle();
                enviarUsuario.putString("keyNombre", etUsername.getText().toString());

                Intent intent = new Intent(MainActivity.this, Juego.class);
                intent.putExtras(enviarUsuario);
                startActivity(intent);


            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Verifica si el resultado es de la actividad del juego y si fue exitoso
        if (requestCode == CODIGO_PARA_INICIAR_JUEGO && resultCode == RESULT_OK && data != null) {
            // Obtiene el número de pares descubiertos del intent devuelto por la actividad del juego
            int paresDescubiertos = data.getIntExtra("paresDescubiertos", 0);
            // Muestra el número de pares descubiertos en un Toast
            Toast.makeText(this, "Se han descubierto " + paresDescubiertos + " pares", Toast.LENGTH_SHORT).show();
        }
    }


}
