package com.github.britter.springbootherokudemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.britter.springbootherokudemo.helper.uniquejpa.Unique;
import com.github.britter.springbootherokudemo.helper.uniquejpa.service.UniqueServices;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
public class DataPegawai {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    String id;
   // @Unique(service = UniqueServices.class, fieldName = "nik", message = "nik.unique")
    @Size(min = 9, message = "nik.size")
    @NotEmpty(message = "nik.notnull")
    String nik;
    @NotEmpty(message = "nama.notnull")
    String nama;
    @NotEmpty(message = "jenkel.notnull")
    String jenkel;
    @NotEmpty(message = "tempatlahir.notnull")
    String tempatlahir;
    @NotNull(message = "tgllahir.notnull")
    @Temporal(TemporalType.TIMESTAMP)
    Date   tgllahir;
    @NotEmpty(message = "agama.notnull")
    String agama;
    @NotEmpty(message = "status.notnull")
    String status;
    @NotEmpty(message = "alamat.notnull")
    String alamat;
    @Lob
    byte[] foto;
    @NotEmpty(message = "jabatan.notnull")
    String jabatan;
    @NotEmpty(message = "statuskaryawan.notnull")
    String statuskaryawan;
    @NotNull(message = "tglmasuk.notnull")
    @Temporal(TemporalType.TIMESTAMP)
    Date tglmasuk;
    String masakerja;
    @NotEmpty(message = "pendidikan.notnull")
    String pendidikan;
    @Column(name = "EMAIL", length = 50)
   // @Unique(service = UniqueServices.class, fieldName = "email", message = "email.unique")
    @Email(message = "email.valid")
    String email;
    String notelp;

    @OneToMany(mappedBy = "dataPegawai")
    @JsonIgnore
    private List<DataGaji> dataGajiList;

    private Date createat;
    private Date updateat;

    public DataPegawai() {
    }

    public DataPegawai(String nik, String nama, String jenkel, String tempatlahir, Date tgllahir, String agama, String status, String alamat, byte[] foto, String jabatan, String statuskaryawan, Date tglmasuk, String masakerja, String pendidikan, String email, String notelp, Date createat, Date updateat) {
        this.nik = nik;
        this.nama = nama;
        this.jenkel = jenkel;
        this.tempatlahir = tempatlahir;
        this.tgllahir = tgllahir;
        this.agama = agama;
        this.status = status;
        this.alamat = alamat;
        this.foto = foto;
        this.jabatan = jabatan;
        this.statuskaryawan = statuskaryawan;
        this.tglmasuk = tglmasuk;
        this.masakerja = masakerja;
        this.pendidikan = pendidikan;
        this.email = email;
        this.notelp = notelp;
        this.createat = createat;
        this.updateat = updateat;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public Date getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(Date tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getStatuskaryawan() {
        return statuskaryawan;
    }

    public void setStatuskaryawan(String statuskaryawan) {
        this.statuskaryawan = statuskaryawan;
    }

    public Date getTglmasuk() {
        return tglmasuk;
    }

    public void setTglmasuk(Date tglmasuk) {
        this.tglmasuk = tglmasuk;
    }

    public String getMasakerja() {
        return masakerja;
    }

    public void setMasakerja(String masakerja) {
        this.masakerja = masakerja;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }

    public List<DataGaji> getDataGajiList() {
        return dataGajiList;
    }

    public void setDataGajiList(List<DataGaji> dataGajiList) {
        this.dataGajiList = dataGajiList;
    }

    @Override
    public String toString() {
        return "DataPegawai{" +
                "id='" + id + '\'' +
                ", nik='" + nik + '\'' +
                ", nama='" + nama + '\'' +
                ", jenkel='" + jenkel + '\'' +
                ", tempatlahir='" + tempatlahir + '\'' +
                ", tgllahir=" + tgllahir +
                ", agama='" + agama + '\'' +
                ", status='" + status + '\'' +
                ", alamat='" + alamat + '\'' +
                ", foto=" + Arrays.toString(foto) +
                ", jabatan='" + jabatan + '\'' +
                ", statuskaryawan='" + statuskaryawan + '\'' +
                ", tglmasuk=" + tglmasuk +
                ", masakerja='" + masakerja + '\'' +
                ", pendidikan='" + pendidikan + '\'' +
                ", email='" + email + '\'' +
                ", notelp='" + notelp + '\'' +
                ", dataGajiList=" + dataGajiList +
                ", createat=" + createat +
                ", updateat=" + updateat +
                '}';
    }

}


