package com.github.britter.springbootherokudemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.britter.springbootherokudemo.helper.uniquejpa.Unique;
import com.github.britter.springbootherokudemo.helper.uniquejpa.service.UniqueServices;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class DataKantor {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @NotEmpty(message = "kodekantor.notnull")
    //@Unique(service = UniqueServices.class,fieldName = "kodekantor",message = "kodekantor.unique")
    @Size(min = 3, message = "kodekantor.size")
    private String kodekantor;
    @NotEmpty(message = "namakantor.notnull")
    private String namakantor;
    @NotEmpty(message = "alamatkantor.notnull")
    private String alamat;
    private String kodepos;

    @JsonIgnore
    @OneToMany(mappedBy = "dataKantor")
    private List<UserDetails> userDetails;
    private Date createat;
    private Date updateat;

    public DataKantor() {
    }

    public DataKantor(String kodekantor, String namakantor, String alamat, String kodepos, Date createat, Date updateat) {
        this.kodekantor = kodekantor;
        this.namakantor = namakantor;
        this.alamat = alamat;
        this.kodepos = kodepos;
        this.createat = createat;
        this.updateat = updateat;
    }

    public String getKodekantor() {
        return kodekantor;
    }

    public void setKodekantor(String kodekantor) {
        this.kodekantor = kodekantor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamakantor() {
        return namakantor;
    }

    public void setNamakantor(String namakantor) {
        this.namakantor = namakantor;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }

    public List<UserDetails> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(List<UserDetails> userDetails) {
        this.userDetails = userDetails;
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

    @Override
    public String toString() {
        return "DataKantor{" +
                "id='" + id + '\'' +
                ", kodekantor='" + kodekantor + '\'' +
                ", namakantor='" + namakantor + '\'' +
                ", alamat='" + alamat + '\'' +
                ", kodepos='" + kodepos + '\'' +
                ", userDetails=" + userDetails +
                ", createat=" + createat +
                ", updateat=" + updateat +
                '}';
    }


}