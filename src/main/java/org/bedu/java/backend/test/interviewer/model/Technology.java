package org.bedu.java.backend.test.interviewer.model;

import java.util.ArrayList;

public class Technology extends Model {
    static ArrayList<Technology> data = new ArrayList<>();
    public Technology(String name, String slug, String description) {
        super(name, slug, description);
    }

    @Override
    public Technology add() {
        data.add(this);
        return this;
    }
}