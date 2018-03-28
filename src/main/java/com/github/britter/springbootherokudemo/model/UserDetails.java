package com.github.britter.springbootherokudemo.model;

import com.github.britter.springbootherokudemo.helper.uniquejpa.Unique;
import com.github.britter.springbootherokudemo.helper.uniquejpa.service.UniqueServices;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

   // @Unique(service = UniqueServices.class, fieldName = "nik", message = "nik.unique")
    @Size(min = 8, message = "nik.size")
    @NotEmpty(message = "nik.notnull")
    private String nik;

    @Column(name = "FIRSTNAME", length = 50)
    @NotEmpty(message = "firstname.notnull")
    @Size(min = 5, max = 50, message = "firstname.size")
    private String firstname;

    @Column(name = "LASTNAME", length = 50)
    @NotEmpty(message = "lastname.notnull")
    @Size(min = 5, max = 50, message = "lastname.size")
    private String lastname;


    @Column(name = "EMAIL", length = 50)
    @NotEmpty(message = "email.notnull")
   // @Unique(service = UniqueServices.class, fieldName = "email", message = "email.unique")
    @Email(message = "email.valid")
    private String email;

    @NotEmpty(message = "jabatan.notnull")
    private String jabatan;

    @ManyToOne()
    @JoinColumn(name = "datakantorID")
    private DataKantor dataKantor;

    private Date tglcreate;
    private Date tglupdate;

    public UserDetails() {
    }

    public UserDetails(String nik, String firstname, String lastname, String email, String jabatan, DataKantor dataKantor, Date tglcreate, Date tglupdate) {
        this.nik = nik;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.jabatan = jabatan;
        this.dataKantor = dataKantor;
        this.tglcreate = tglcreate;
        this.tglupdate = tglupdate;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public DataKantor getDataKantor() {
        return dataKantor;
    }

    public void setDataKantor(DataKantor dataKantor) {
        this.dataKantor = dataKantor;
    }

    public Date getTglcreate() {
        return tglcreate;
    }

    public void setTglcreate(Date tglcreate) {
        this.tglcreate = tglcreate;
    }

    public Date getTglupdate() {
        return tglupdate;
    }

    public void setTglupdate(Date tglupdate) {
        this.tglupdate = tglupdate;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", nik='" + nik + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", jabatan='" + jabatan + '\'' +
                ", dataKantor=" + dataKantor +
                ", tglcreate=" + tglcreate +
                ", tglupdate=" + tglupdate +
                '}';
    }
}