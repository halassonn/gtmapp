package com.github.britter.springbootherokudemo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Setting_model {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String status;
    private String tjkesehatan;

    public Setting_model() {
    }

    public Setting_model(String status, String tjkesehatan) {
        this.status = status;
        this.tjkesehatan = tjkesehatan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public String getTjkesehatan() {
        return tjkesehatan;
    }

    public void setTjkesehatan(String tjkesehatan) {
        this.tjkesehatan = tjkesehatan;
    }

    @Override
    public String toString() {
        return "Setting_model{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", tjkesehatan='" + tjkesehatan + '\'' +
                '}';
    }
}
