package com.example.indent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class TelaMensagemActivity extends AppCompatActivity {

    Button btnEnviar, btnVoltar;
    EditText textMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_mensagem);

        btnEnviar = (Button) findViewById(R.id.buttonEnviar);
        btnVoltar = (Button) findViewById(R.id.buttonVoltar);
        textMensagem = (EditText) findViewById(R.id.editTextTextMultiLine2);

        btnEnviar.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,textMensagem.getText().toString());
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        });

        btnVoltar.setOnClickListener(v -> {
            finish();
        });

    }
}