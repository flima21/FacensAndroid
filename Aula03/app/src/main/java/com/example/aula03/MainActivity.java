package com.example.aula03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nota1;
    EditText nota2;
    EditText resultado;
    RadioGroup medias;
    boolean isSimples = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = (EditText) findViewById(R.id.nota1);
        nota2 = (EditText) findViewById(R.id.nota2);
        resultado = (EditText) findViewById(R.id.resultado);

        medias = findViewById(R.id.radioGroup);

        nota1.setText("0");
        nota2.setText("0");
        resultado.setText("0");

        /**
         * Monta a função para pegar o check
         */

        medias.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioChecked = findViewById(checkedId);
            System.out.println(radioChecked);
        });
    }
}