package org.bedu.java.backend.test.interviewer.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Discipline extends Model{
    static ArrayList<Discipline> data = new ArrayList<>();
    public Discipline(String name, String slug, String description) {
        super(name, slug, description);
    }

    @Override
    public Discipline add() {
        data.add(this);
        return this;
    }
}
