package id.example.kpbryan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import id.example.kpbryan.model.Data;

public class MainActivity3 extends AppCompatActivity {
    EditText nama, ttl, sex, alamat, pemeriksaan, jenisPemeriksaan, harga;
    double hargaa;
    Data data;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        hargaa = getIntent().getDoubleExtra("harga", 0);
        data = (Data) getIntent().getSerializableExtra("data");

        home = findViewById(R.id.home);
        nama = findViewById(R.id.nama);
        ttl = findViewById(R.id.ttl);
        sex = findViewById(R.id.sex);
        alamat = findViewById(R.id.alamat);
        pemeriksaan = findViewById(R.id.pemeriksaan);
        jenisPemeriksaan = findViewById(R.id.jenisPemeriksaan);
        harga = findViewById(R.id.harga);

        nama.setText(data.getPasien().getNama());
        ttl.setText(data.getPasien().getTtl());
        sex.setText(data.getPasien().getSex());
        alamat.setText(data.getPasien().getAlamat());
        pemeriksaan.setText(data.getPemeriksaan().getJenis());
        jenisPemeriksaan.setText(data.getPemeriksaan().getSubJenis());
        harga.setText("Biaya Pemeriksaan : "+String.valueOf(hargaa));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), MainActivity1.class));
                finish();
            }
        });
    }
}