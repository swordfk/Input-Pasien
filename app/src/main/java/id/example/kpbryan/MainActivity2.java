package id.example.kpbryan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import id.example.kpbryan.model.Data;
import id.example.kpbryan.model.Pasien;
import id.example.kpbryan.model.Pemeriksaan;
import id.example.kpbryan.util.DropDown;

public class MainActivity2 extends AppCompatActivity {
    EditText jenisPemeriksaan;
    Button submit;
    Pasien pasien;
    DropDown dropDown;
    double harga = 0;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pasien = (Pasien) getIntent().getSerializableExtra("pasien");

        dropDown = findViewById(R.id.dropDown);
        jenisPemeriksaan = findViewById(R.id.jenisPemeriksaan);
        submit = findViewById(R.id.btnSubmit);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("pemeriksaan");

        ArrayList<String> options = new ArrayList<>();
        options.add("Hematologi");
        options.add("Kimia Darah");
        options.add("Serologi");

        dropDown.setOptions(options);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dropDown.getText().toString().contains("Hematologi")){
                    harga = 500000;
                }else if (dropDown.getText().toString().contains("Kimia Darah")){
                    harga = 700000;
                }else {
                    harga = 1000000;
                }

                Pemeriksaan pemeriksaan = new Pemeriksaan(
                        dropDown.getText().toString(),
                        jenisPemeriksaan.getText().toString()
                );

                Data data = new Data(
                        pasien,
                        pemeriksaan
                );

                String uploadId = ref.push().getKey();
                ref.child(uploadId).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                        i.putExtra("data", data);
                        i.putExtra("harga", harga);
                        startActivity(i);
                    }
                });

            }
        });
    }
}