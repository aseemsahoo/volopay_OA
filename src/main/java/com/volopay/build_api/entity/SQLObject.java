package com.volopay.build_api.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
// mapping to table in database (DO CSV)
@Table(name="data")
public class SQLObject
{
    @Id
    @Column(name="id")
    private int id;

    @Column(name="date")
    private String date;

    @Column(name="user")
    private String user;

    @Column(name="department")
    private String department;

    @Column(name="software")
    private String software;

    @Column(name="seats")
    private int seats;
    @Column(name="amount")
    private String amount;

    public SQLObject() {};

    @Autowired
    public SQLObject(int id, String date, String user, String department, String software, int seats, String amount) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.department = department;
        this.software = software;
        this.seats = seats;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
