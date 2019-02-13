package com.gzeinnumer.myminyak;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quises extends AppCompatActivity {

    TextView soal;
    RadioGroup grubJawaban;
    RadioButton chA, chB, chC, chD;

    Button btnSubmit;

    ArrayList<ModelSoal> list = new ArrayList<>();

    int index = 0;
    private String pilihanJawaban = "";
    int nilai = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quises);
        ButterKnife.bind(this);
        btnSubmit = findViewById(R.id.btnSubmit);
        soal= findViewById(R.id.soal);

        grubJawaban = findViewById(R.id.grubJawaban);
        chA = findViewById(R.id.chA);
        chB = findViewById(R.id.chB);
        chC = findViewById(R.id.chC);
        chD = findViewById(R.id.chD);

        list.add(new ModelSoal(1, "Soal A", "A1", "B1", "C1", "D1", "A1"));
        list.add(new ModelSoal(2, "Soal B", "A2", "B2", "C2", "D2", "B2"));
        list.add(new ModelSoal(3, "Soal C", "A3", "B3", "C3", "D3", "C3"));
        list.add(new ModelSoal(4, "Soal D", "A4", "B4", "C4", "D4", "D4"));
        list.add(new ModelSoal(5, "Soal E", "A5", "B5", "C5", "D5", "A5"));

        setSoal(index);
        index++;

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index < list.size()){
                    checkJawaban();
                    setSoal(index);
                    unCheck();
                    index++;
                } else {
                    //Toast.makeText(Quises.this, "Done", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Quises.this, String.valueOf(nilai), Toast.LENGTH_SHORT).show();
                    checkJawaban();
                    Intent intent = new Intent(Quises.this, HasilActivity.class);
                    intent.putExtra("nilai", String.valueOf(nilai));
                    startActivity(intent);
                }
            }
        });
    }

    private void unCheck() {
        if(chA.isChecked()){
            chA.setChecked(false);
        } else if(chB.isChecked()){
            chB.setChecked(false);
        } else if(chC.isChecked()){
            chC.setChecked(false);
        } else if(chD.isChecked()){
            chD.setChecked(false);
        }
    }

    private void checkJawaban() {
        int radioButtonID = grubJawaban.getCheckedRadioButtonId();
        RadioButton radioButton = grubJawaban.findViewById(radioButtonID);
        if(!chA.isChecked() && !chB.isChecked() && !chC.isChecked() && !chD.isChecked()){
            Toast.makeText(this, "Pilih Salah Satu!!!", Toast.LENGTH_SHORT).show();
        } else {
            String selectedtext = (String) radioButton.getText();
            setNilai(selectedtext);
            //Toast.makeText(this, selectedtext, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "nilai kamu "+nilai, Toast.LENGTH_SHORT).show();
        }
    }

    private void setNilai(String selectedtext) {
        //Toast.makeText(this, selectedtext , Toast.LENGTH_SHORT).show();
        if (selectedtext.equals(list.get(index-1).getJawaban())){
            nilai = nilai + 10;
        }
    }

    private void setSoal(int index) {
        switch (index){
            case 0:
                setSoalValue(
                        list.get(0).getSoal(),
                        list.get(0).getA(),
                        list.get(0).getB(),
                        list.get(0).getC(),
                        list.get(0).getD());
                break;
            case 1:
                setSoalValue(
                        list.get(1).getSoal(),
                        list.get(1).getA(),
                        list.get(1).getB(),
                        list.get(1).getC(),
                        list.get(1).getD());
                break;
            case 2:
                setSoalValue(
                        list.get(2).getSoal(),
                        list.get(2).getA(),
                        list.get(2).getB(),
                        list.get(2).getC(),
                        list.get(2).getD());
                break;
            case 3:
                setSoalValue(
                        list.get(3).getSoal(),
                        list.get(3).getA(),
                        list.get(3).getB(),
                        list.get(3).getC(),
                        list.get(3).getD());
                break;
            case 4:
                setSoalValue(
                        list.get(4).getSoal(),
                        list.get(4).getA(),
                        list.get(4).getB(),
                        list.get(4).getC(),
                        list.get(4).getD());
                break;
        }
    }
    private void setSoalValue(String s, String a, String b, String c, String d) {
        soal.setText(s);
        chA.setText(a);
        chB.setText(b);
        chC.setText(c);
        chD.setText(d);
    }
}
