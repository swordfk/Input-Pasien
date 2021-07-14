package id.example.kpbryan.model;

import java.io.Serializable;

public class Data implements Serializable {
    Pasien pasien;
    Pemeriksaan pemeriksaan;

    public Data(Pasien pasien, Pemeriksaan pemeriksaan) {
        this.pasien = pasien;
        this.pemeriksaan = pemeriksaan;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Pemeriksaan getPemeriksaan() {
        return pemeriksaan;
    }

    public void setPemeriksaan(Pemeriksaan pemeriksaan) {
        this.pemeriksaan = pemeriksaan;
    }
}
