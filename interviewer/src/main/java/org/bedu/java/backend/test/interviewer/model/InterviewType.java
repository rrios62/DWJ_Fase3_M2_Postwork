package org.bedu.java.backend.test.interviewer.model;

import java.util.ArrayList;

public class InterviewType extends Model {

    static ArrayList<InterviewType> data = new ArrayList<>();
    public InterviewType(String name, String slug, String description) {
        super(name, slug, description);
    }

    @Override
    public InterviewType add() {
        data.add(this);
        return this;
    }
}
