package com.example.ac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Faça um aplicativo modelo quizz, esse app deverá conter:
     * • No mínimo 2 questões múltiplas escolha.
     * • Cada questão pertence a uma determinada área o que deverá ser identificado para o aluno.
     * • Para cada questão deverá ser apresentado 5 opções de resposta, sendo apenas 1 correta.
     * • No final um botão para averiguar a quantidade de acertos e/ou erros.
     */
    Button buttonResult;
    RadioGroup radioGroupFirst, radioGroup2;
    RadioButton optionOneFirst,
                optionTwoFirst,
                optionThreeFirst,
                optionFourFirst,
                radioButton5,
                radioButton6,
                radioButton7,
                radioButton8;
    TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.radioGroupFirst = (RadioGroup)findViewById(R.id.radioGroupFirst);
        this.radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        this.buttonResult = (Button) findViewById(R.id.buttonResult);
        this.resposta = findViewById(R.id.resposta);

        RadioButton optionOneFirst = findViewById(R.id.optionOneFirst);
        RadioButton optionTwoFirst = findViewById(R.id.optionTwoFirst);
        RadioButton optionThreeFirst = findViewById(R.id.optionThreeFirst);
        RadioButton optionFourFirst = findViewById(R.id.optionFourFirst);

        RadioButton radioButton5 = findViewById(R.id.radioButton5);
        RadioButton radioButton6 = findViewById(R.id.radioButton6);
        RadioButton radioButton7 = findViewById(R.id.radioButton7);
        RadioButton radioButton8 = findViewById(R.id.radioButton8);
    }

    public void clickButton(View view) {
        this.buttonResult.setOnClickListener(v -> {
            int acertosFirst = 0;
            int errosFirst = 0;

            int acertosSecond = 0;
            int errosSecond = 0;

            if(this.radioGroupFirst.getCheckedRadioButtonId() == R.id.optionOneFirst) {
                acertosFirst = acertosFirst + 1;
                errosFirst = errosFirst - 1;
            }
            else {
                acertosFirst = acertosFirst - 1;
                errosFirst = errosFirst + 1;
            }

            if(this.radioGroup2.getCheckedRadioButtonId() == R.id.radioButton8) {
                acertosSecond = acertosSecond + 1;
                errosSecond = errosSecond - 1;
            }
            else {
                acertosSecond = acertosSecond - 1;
                errosSecond = errosSecond + 1;
            }

            if(acertosSecond <= 0) {
                acertosSecond = 0;
            }

            if(acertosFirst <= 0) {
                acertosFirst = 0;
            }

            if(errosSecond <= 0) {
                errosSecond = 0;
            }

            if(errosFirst <= 0) {
                errosFirst = 0;
            }

            int acertos = acertosFirst + acertosSecond;
            int erros = errosFirst + errosSecond;

            this.resposta.setText("Você acertou " + String.valueOf(acertos) + " e errou " + String.valueOf(erros));
        });
    }
}