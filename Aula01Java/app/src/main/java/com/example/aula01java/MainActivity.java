package com.example.aula01java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView userName;
    private TextView userSex;
    private TextView userAge;
    private TextView carValue;
    private TextView carValueTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextView) findViewById(R.id.userName);
        userSex  = (TextView) findViewById(R.id.userSex);
        userAge  = (TextView) findViewById(R.id.userAge);
        carValue = (TextView) findViewById(R.id.carValue);

    }

    public void buttonCopiarClick(View view) {
        double valorApolice = 0;
        double valueCar = Double.parseDouble(carValue.getText().toString());

        if((Integer.parseInt(userAge.getText().toString()) >= 35) && (userSex.getText().toString().toLowerCase().equals("masculino"))) {
            valorApolice = (valueCar * 0.10) + valueCar;
        }

        if((Integer.parseInt(userAge.getText().toString()) < 35) && (userSex.getText().toString().toLowerCase().equals("masculino"))) {
            valorApolice = (valueCar * 0.05) + valueCar;
        }

        if((userSex.getText().toString().toLowerCase().equals("feminino"))) {
            valorApolice = (valueCar * 0.02) + valueCar;
        }

        carValueTotal.setText(valorApolice + "");
        Toast.makeText(this,userName.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart","Entrou no onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume","Entrou no onResume");
    }
}