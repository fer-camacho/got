package com.example.got;

import java.io.Serializable;

public class Personaje implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String title;
    private String family;
    private int imgResource; //si trabajamos con url seria string

    public Personaje(int id, String firstName, String lastName, String fullName, String title, String family, int imgResource) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.title = title;
        this.family = family;
        this.imgResource = imgResource;
    }

    public Personaje(int id, String fullName, String family, int imgResource) {
        this.id = id;
        this.fullName = fullName;
        this.family = family;
        this.imgResource = imgResource;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTitle() {
        return title;
    }

    public String getFamily() {
        return family;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
