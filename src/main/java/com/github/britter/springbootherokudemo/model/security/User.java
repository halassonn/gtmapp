package com.github.britter.springbootherokudemo.model.security;


import com.github.britter.springbootherokudemo.helper.uniquejpa.Unique;
import com.github.britter.springbootherokudemo.helper.uniquejpa.service.UniqueServices;
import com.github.britter.springbootherokudemo.model.UserDetails;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private String id;

    @Unique(service = UniqueServices.class,fieldName = "username",message = "username.unique")
    @Size(min = 8,message = "username.size")
    @NotNull(message = "username.notnull")
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull(message = "password.notnull")
    @Size(min = 8, max = 100,message = "password.size")
    private String password;

    @Column(name = "ENABLED")
    private Boolean enabled;
    private String kode;
    @Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    //@NotNull

    private Date lastPasswordResetDate;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_AUTHORITY", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Authority> authorities;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usersdetail")
    private UserDetails userDetails;

    public User() {
        super();
    }

    public User(String username, String password, Boolean enabled, String kode, Date lastPasswordResetDate, List<Authority> authorities,  UserDetails userDetails) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.kode = kode;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;

        this.userDetails = userDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }




    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", kode='" + kode + '\'' +
                ", lastPasswordResetDate=" + lastPasswordResetDate +
                ", authorities=" + authorities +
                ", userDetails=" + userDetails +
                '}';
    }
}
