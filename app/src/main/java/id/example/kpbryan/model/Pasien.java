package id.example.kpbryan.model;

import java.io.Serializable;

public class Pasien implements Serializable {
    String nama;
    String ttl;
    String sex;
    String alamat;

    public Pasien(String nama, String ttl, String sex, String alamat) {
        this.nama = nama;
        this.ttl = ttl;
        this.sex = sex;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
