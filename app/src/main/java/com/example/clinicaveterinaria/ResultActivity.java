package com.example.clinicaveterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Exibir();
    }

    public void Exibir()
    {
        TextView txtvwcpftutor = findViewById(R.id.txtvwcpftutor);
        TextView txtvwmessage = findViewById(R.id.txtvwmessage);
        TextView txtvwbemvindo = findViewById(R.id.txtvwbemvindo);

        try
        {
            Intent starter = getIntent();
            Bundle dados = starter.getBundleExtra(MainActivity.DADOS);

            String nomepet = dados.getString(MainActivity.NOME_PET);
            String cpftutor = dados.getString(MainActivity.CPF_TUTOR);
            String generopet = dados.getString(MainActivity.GENERO_PET);

            if (generopet.equals("FÊMEA"))
            {
                findViewById(R.id.resultlayout).setBackgroundResource(R.drawable.img2);
                txtvwbemvindo.setTextColor(Color.parseColor("#DB9679"));
            }
            else
            {
                findViewById(R.id.resultlayout).setBackgroundResource(R.drawable.img3);
                txtvwbemvindo.setTextColor(Color.parseColor("#B8D0A5"));
            }

            String message = String.format("APLICAÇÃO EM CONSTRUÇÃO! A EQUIPE DESENVOLVEDORA ESPERA QUE %s ESTEJA BEM!", nomepet.toUpperCase());
            txtvwmessage.setText(message);

            String userid = String.format("ID DO USUÁRIO: %s", cpftutor);
            txtvwcpftutor.setText(userid);
        }
        catch (NullPointerException E)
        {
            String erro = String.format("ERRO! TENTE NOVAMENTE.");
            txtvwmessage.setText(erro);
            Toast aviso = Toast.makeText(this, "COMPLETE TODOS OS CAMPOS!", Toast.LENGTH_LONG);
            aviso.show();
        }
    }
}