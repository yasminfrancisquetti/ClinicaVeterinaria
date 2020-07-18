package com.example.clinicaveterinaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static String DADOS      = "com.example.app.dados";
    public static String NOME_PET   = "com.example.app.nomepet";
    public static String GENERO_PET = "com.example.app.generopet";
    public static String CPF_TUTOR  = "com.example.app.cpftutor";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Transferir(View btncontinuar)
    {
            Intent starter = new Intent(this, ResultActivity.class);

            EditText    edtnomepet      =   findViewById(R.id.edtnomepet)     ;
            EditText    edtnumcpftutor  =   findViewById(R.id.edtnumcpftutor) ;
            RadioButton rdbmasculino    =   findViewById(R.id.rdbmasculino)   ;
            RadioButton rdbfeminino     =   findViewById(R.id.rdbfeminino)    ;

            Bundle dados = new Bundle();

            dados.putString(NOME_PET, edtnomepet.getText().toString());
            dados.putString(CPF_TUTOR, edtnumcpftutor.getText().toString());

            if (rdbmasculino.isChecked())       { dados.putString(GENERO_PET, "MACHO"); }
            else if (rdbfeminino.isChecked())   { dados.putString(GENERO_PET, "FÊMEA"); }

            starter.putExtra(DADOS, dados);
            startActivity(starter);

    }
}