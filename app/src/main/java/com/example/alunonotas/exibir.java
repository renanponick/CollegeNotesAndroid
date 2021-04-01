package com.example.alunonotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class exibir extends AppCompatActivity {
    String[] aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);

        Bundle args = getIntent().getExtras();
        aluno = args.getStringArray("aluno");

        TextView tNome = (TextView) findViewById(R.id.textName);
        TextView tEnd = (TextView) findViewById(R.id.textEnd);
        TextView tData = (TextView) findViewById(R.id.textData);
        TextView tN1 = (TextView) findViewById(R.id.textN1);
        TextView tN2 = (TextView) findViewById(R.id.textN2);
        TextView tN3 = (TextView) findViewById(R.id.textN3);
        TextView tN4 = (TextView) findViewById(R.id.textN4);
        TextView tMed = (TextView) findViewById(R.id.textMed);

        tNome.setText(aluno[0]);
        tEnd.setText(aluno[1]);
        tData.setText(aluno[2]);
        tN1.setText(aluno[3]);
        tN2.setText(aluno[4]);
        tN3.setText(aluno[5]);
        tN4.setText(aluno[6]);
        tMed.setText(aluno[7]);
    }
}