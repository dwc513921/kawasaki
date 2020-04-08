package com.csdj.dwc.pojo;

import javax.persistence.*;

@Table(name = "cityarea")
public class CityArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "namearea")
    private String namearea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return namearea;
    }

    public void setName(String name) {
        this.namearea = name;
    }
}
