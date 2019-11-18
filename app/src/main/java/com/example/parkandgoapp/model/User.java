package com.example.parkandgoapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

/**
 * ParkAndGoApp created by test
 * Student ID: 991541369
 * on 2019-11-14
 */
@Entity(tableName = "parkandgo_table")
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber;

    @ColumnInfo(name = "numberPlate")
    private String numberPlate;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name="date")
    private Date date;

    public User(String username,String password, String phoneNumber,String numberPlate, String email, Date date){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.numberPlate = numberPlate;
        this.email = email;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){this.password= password;}

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){this.email = email;}

    public Date getDate() {
        return date;
    }
    public void setDate(Date date){this.date = date;}

    public String getNumberPlate() {return numberPlate;}
    public void setNumberPlate(String numberPlate){this.numberPlate = numberPlate;}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ",username='" + '\'' +
                ",password='" + '\'' +
                ",phoneNumber='" + '\'' +
                ",numberPlate='" + '\'' +
                ",email='" + '\'' +
                "date='" + '\'' +
                '}';
    }

}
