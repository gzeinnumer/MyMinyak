package com.gzeinnumer.myminyak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        Intent intent = getIntent();
        String nilai = intent.getStringExtra("nilai");
        TextView hasil = findViewById(R.id.hasil);
        hasil.setText(nilai);
    }
}
