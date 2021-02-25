package com.example.myapplication;

public class Mahasiswa {
    private String nama;
    private String npm;
    private String nohp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Mahasiswa(String nama, String npm, String nohp, String email) {
        this.nama = nama;
        this.npm = npm;
        this.nohp = nohp;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}
