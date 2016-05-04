package com.unlimitedappworks.u3_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tv_puntos;
    private EditText edt_num;
    private Random rnd;
    private SharedPreferences sh;
    private int numero, puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_puntos = (TextView) findViewById(R.id.txt_puntaje);
        edt_num = (EditText) findViewById(R.id.edt_adiv);
        rnd = new Random();
        sh = getSharedPreferences("pref", 0);
        puntos = sh.getInt("puntos", 0);
        tv_puntos.setText("Puntaje: " + puntos);
        numero = rnd.nextInt(49) + 1;
    }

    public void intentar(View view) {
        if (Integer.valueOf(edt_num.getText().toString()) == numero) {
            Toast.makeText(this, "Felicidades adivinaste el numero", Toast.LENGTH_LONG).show();
            puntos++;
            sh.edit().putInt("puntos", puntos + 1).commit();
            numero = rnd.nextInt(49) + 1;
            tv_puntos.setText("Puntaje: " + puntos);
        } else {
            Toast.makeText(this, "Numero equivocado", Toast.LENGTH_LONG).show();
        }
        edt_num.setText("");
    }
}
