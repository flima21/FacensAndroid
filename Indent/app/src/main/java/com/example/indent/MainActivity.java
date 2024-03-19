package com.example.indent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonEnviaMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Recupera o botão
        buttonEnviaMensagem = (Button) findViewById(R.id.buttonTelaMensagem);
        // Sobrescrita do método click do botão
        buttonEnviaMensagem.setOnClickListener(v -> {
            Intent intent = new Intent(this, TelaMensagemActivity.class);

            startActivity(intent);
        });


    }




}