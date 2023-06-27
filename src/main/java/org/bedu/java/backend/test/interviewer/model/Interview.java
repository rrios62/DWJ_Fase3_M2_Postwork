package org.bedu.java.backend.test.interviewer.model;

import org.bedu.java.backend.test.interviewer.Interviewer;

import java.io.Serializable;
import java.util.ArrayList;

public class Interview implements Serializable {
    static ArrayList<Interview>data;
    Long id;
    Candidate candidate;
    InterviewType type;
    Interviewer interviewer;



}
