package id.example.kpbryan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

import id.example.kpbryan.model.Pasien;

public class MainActivity1 extends AppCompatActivity {
    EditText nama, ttl, sex, alamat;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        nama = findViewById(R.id.nama);
        ttl = findViewById(R.id.ttl);
        sex = findViewById(R.id.sex);
        alamat = findViewById(R.id.alamat);
        next = findViewById(R.id.btnNext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pasien pasien = new Pasien(
                        nama.getText().toString(),
                        ttl.getText().toString(),
                        sex.getText().toString(),
                        alamat.getText().toString()
                );

                Intent i = new Intent(MainActivity1.this, MainActivity2.class);
                i.putExtra("pasien", (Serializable) pasien);
                startActivity(i);
            }
        });
    }
}