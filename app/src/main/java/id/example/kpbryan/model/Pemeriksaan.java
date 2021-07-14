package id.example.kpbryan.model;

import java.io.Serializable;

public class Pemeriksaan implements Serializable {
    String jenis;
    String subJenis;

    public Pemeriksaan(String jenis, String subJenis) {
        this.jenis = jenis;
        this.subJenis = subJenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getSubJenis() {
        return subJenis;
    }

    public void setSubJenis(String subJenis) {
        this.subJenis = subJenis;
    }
}
