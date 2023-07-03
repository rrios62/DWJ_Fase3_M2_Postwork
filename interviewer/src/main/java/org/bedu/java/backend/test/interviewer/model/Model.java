package org.bedu.java.backend.test.interviewer.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Model implements Serializable {
    static ArrayList<Model> data;
    Long id;
    String name;
    String slug;
    String description;

    public Model(String name, String slug, String description) {
        this.name = name;
        this.slug = slug;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract Model add();

    public void save(String name, String slug, String description) {
        if (!name.equals(""))
            this.name = name;

        if (!slug.equals(""))
            this.slug = slug;

        if (!description.equals(""))
            this.description = description;

        data.add(this);
    }

    public void delete() {
        data.remove(this);
    }
}