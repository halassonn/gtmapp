package com.github.britter.springbootherokudemo.model;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DataGaji {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid2")
    private String id;
    private String gapok;
    private String tjistri;
    private String tjanak;
    private String tjjabatan;
    private String tjkesehatan;
    private String tjkhusus;
    private String tjtransport;
    private String tjperalihan;
    private String tjpangan;
    private String tjpengabdian;
    private String gajikotor;
    private String pttht;
    private String ptpajak;
    private String gabersih;
    private String pembulatan;
    private Date tglgaji;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pegawai_id", nullable = false)
    private DataPegawai dataPegawai;
    private Date createat;
    private Date updateat;


    public DataGaji() {
    }

    public DataGaji(String gapok, String tjistri, String tjanak, String tjjabatan, String tjkesehatan, String tjkhusus, String tjtransport, String tjperalihan, String tjpangan, String tjpengabdian, String gajikotor, String pttht, String ptpajak, String gabersih, String pembulatan, Date tglgaji, DataPegawai dataPegawai, Date createat, Date updateat) {
        this.gapok = gapok;
        this.tjistri = tjistri;
        this.tjanak = tjanak;
        this.tjjabatan = tjjabatan;
        this.tjkesehatan = tjkesehatan;
        this.tjkhusus = tjkhusus;
        this.tjtransport = tjtransport;
        this.tjperalihan = tjperalihan;
        this.tjpangan = tjpangan;
        this.tjpengabdian = tjpengabdian;
        this.gajikotor = gajikotor;
        this.pttht = pttht;
        this.ptpajak = ptpajak;
        this.gabersih = gabersih;
        this.pembulatan = pembulatan;
        this.tglgaji = tglgaji;
        this.dataPegawai = dataPegawai;
        this.createat = createat;
        this.updateat = updateat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGapok() {
        return gapok;
    }

    public void setGapok(String gapok) {
        this.gapok = gapok;
    }

    public String getTjistri() {
        return tjistri;
    }

    public void setTjistri(String tjistri) {
        this.tjistri = tjistri;
    }

    public String getTjanak() {
        return tjanak;
    }

    public void setTjanak(String tjanak) {
        this.tjanak = tjanak;
    }

    public String getTjjabatan() {
        return tjjabatan;
    }

    public void setTjjabatan(String tjjabatan) {
        this.tjjabatan = tjjabatan;
    }

    public String getTjkesehatan() {
        return tjkesehatan;
    }

    public void setTjkesehatan(String tjkesehatan) {
        this.tjkesehatan = tjkesehatan;
    }

    public String getTjkhusus() {
        return tjkhusus;
    }

    public void setTjkhusus(String tjkhusus) {
        this.tjkhusus = tjkhusus;
    }

    public String getTjtransport() {
        return tjtransport;
    }

    public void setTjtransport(String tjtransport) {
        this.tjtransport = tjtransport;
    }

    public String getTjperalihan() {
        return tjperalihan;
    }

    public void setTjperalihan(String tjperalihan) {
        this.tjperalihan = tjperalihan;
    }

    public String getTjpangan() {
        return tjpangan;
    }

    public void setTjpangan(String tjpangan) {
        this.tjpangan = tjpangan;
    }

    public String getTjpengabdian() {
        return tjpengabdian;
    }

    public void setTjpengabdian(String tjpengabdian) {
        this.tjpengabdian = tjpengabdian;
    }

    public String getGajikotor() {
        return gajikotor;
    }

    public void setGajikotor(String gajikotor) {
        this.gajikotor = gajikotor;
    }

    public String getPttht() {
        return pttht;
    }

    public void setPttht(String pttht) {
        this.pttht = pttht;
    }

    public String getPtpajak() {
        return ptpajak;
    }

    public void setPtpajak(String ptpajak) {
        this.ptpajak = ptpajak;
    }

    public String getGabersih() {
        return gabersih;
    }

    public void setGabersih(String gabersih) {
        this.gabersih = gabersih;
    }

    public String getPembulatan() {
        return pembulatan;
    }

    public void setPembulatan(String pembulatan) {
        this.pembulatan = pembulatan;
    }

    public DataPegawai getDataPegawai() {
        return dataPegawai;
    }

    public void setDataPegawai(DataPegawai dataPegawai) {
        this.dataPegawai = dataPegawai;
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

    public Date getTglgaji() {
        return tglgaji;
    }

    public void setTglgaji(Date tglgaji) {
        this.tglgaji = tglgaji;
    }

    @Override
    public String toString() {
        return "DataGaji{" +
                "id='" + id + '\'' +
                ", gapok='" + gapok + '\'' +
                ", tjistri='" + tjistri + '\'' +
                ", tjanak='" + tjanak + '\'' +
                ", tjjabatan='" + tjjabatan + '\'' +
                ", tjkesehatan='" + tjkesehatan + '\'' +
                ", tjkhusus='" + tjkhusus + '\'' +
                ", tjtransport='" + tjtransport + '\'' +
                ", tjperalihan='" + tjperalihan + '\'' +
                ", tjpangan='" + tjpangan + '\'' +
                ", tjpengabdian='" + tjpengabdian + '\'' +
                ", gajikotor='" + gajikotor + '\'' +
                ", pttht='" + pttht + '\'' +
                ", ptpajak='" + ptpajak + '\'' +
                ", gabersih='" + gabersih + '\'' +
                ", pembulatan='" + pembulatan + '\'' +
                ", tglgaji=" + tglgaji +
                ", dataPegawai=" + dataPegawai +
                ", createat=" + createat +
                ", updateat=" + updateat +
                '}';
    }
}
