package com.example.indent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonEnviaMensagem;
    Button buttonLigacao;
    Button buttonMapa;
    Button buttonSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Recupera o botão
        buttonEnviaMensagem = (Button) findViewById(R.id.buttonTelaMensagem);
        buttonLigacao = (Button) findViewById(R.id.buttonLigacao);
        buttonMapa = (Button) findViewById(R.id.buttonMapa);
        buttonSite = (Button) findViewById(R.id.buttonSite);
        // Sobrescrita do método click do botão
        buttonEnviaMensagem.setOnClickListener(v -> {
            Intent intent = new Intent(this, TelaMensagemActivity.class);

            startActivity(intent);
        });

        // Botão para fazer ligação
        buttonLigacao.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel: " + "9999999");
            Intent intent = new Intent(Intent.ACTION_DIAL,uri);

            int permissionCheck = ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE);

            if(this.verifyPermission(permissionCheck)) {
                startActivity(intent);
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{ android.Manifest.permission.CALL_PHONE },1);
            }
        });

        buttonSite.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://facens.br");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            int permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET);

            if(this.verifyPermission(permissionCheck)) startActivity(intent);
            else {
                ActivityCompat.requestPermissions(this, new String[]{ android.Manifest.permission.INTERNET },1);
            }
        });



    }


    private boolean verifyPermission(int permission) {
        return permission == PackageManager.PERMISSION_GRANTED;
    }


}