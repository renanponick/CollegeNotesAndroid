package com.example.alunonotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String[]> alunosNotas = new ArrayList<>();
    String[] aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // teria que pegar a lista de arrei enviada por parametro
        Bundle args = getIntent().getExtras();
        aluno = args.getStringArray("aluno");

        Button btLogin = (Button) findViewById(R.id.calcular);
        btLogin.setOnClickListener(onClickLogin());
    }
    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tNome = (TextView) findViewById(R.id.edtNome);
                TextView tEnd = (TextView) findViewById(R.id.edtEnd);
                TextView tData = (TextView) findViewById(R.id.edtData);
                TextView tN1 = (TextView) findViewById(R.id.edtNota1);
                TextView tN2 = (TextView) findViewById(R.id.edtNota2);
                TextView tN3 = (TextView) findViewById(R.id.edtNota3);
                TextView tN4 = (TextView) findViewById(R.id.edtNota4);

                String nome = tNome.getText().toString();
                String endereco = tEnd.getText().toString();
                String data = tData.getText().toString();
                float n1 = Float.parseFloat(tN1.getText().toString());
                float n2 = Float.parseFloat(tN2.getText().toString());
                float n3 = Float.parseFloat(tN3.getText().toString());
                float n4 = Float.parseFloat(tN4.getText().toString());
                float med = ((n1+n2+n3+n4)/4);

                // array que armazena as informações que serão adicionadas novas
                String[] newAluno = {
                        nome,
                        endereco,
                        data,
                        String.valueOf(n1),
                        String.valueOf(n2),
                        String.valueOf(n3),
                        String.valueOf(n4),
                        String.valueOf(med)
                };

                int length = alunosNotas.size()+1;
                // arrayList que armazena todos os alunos com suas respectivas informações
                if(length>30){
                    alunosNotas.add(length, newAluno);
                    Intent intent = new Intent(MainActivity.this, exibir.class);
                    startActivityForResult(intent, 2);

                    // teria que passar a lista de array e nao so o aluno
                    Bundle params = new Bundle();
                    params.putStringArray("aluno", newAluno);
                    intent.putExtras(params);
                    startActivity(intent);
                } else {
                    throw new Error("Limite 30 alunos");
                }
            }
        };
    }
}