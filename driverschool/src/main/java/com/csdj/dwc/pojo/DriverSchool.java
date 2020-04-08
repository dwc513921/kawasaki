package com.csdj.dwc.pojo;

import javax.persistence.*;

@Table(name = "driverschools")
public class DriverSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "cityAreaId")
    private int cityAreaId;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phone;

    public String getNamearea() {
        return namearea;
    }

    public void setNamearea(String namearea) {
        this.namearea = namearea;
    }

    private String namearea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityAreaId() {
        return cityAreaId;
    }

    public void setCityAreaId(int cityAreaId) {
        this.cityAreaId = cityAreaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
