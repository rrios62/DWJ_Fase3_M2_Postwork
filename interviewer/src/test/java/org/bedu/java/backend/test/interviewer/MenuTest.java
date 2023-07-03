package org.bedu.java.backend.test.interviewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;

    @BeforeEach
    public void setup() {
        menu = new Menu();
    }
    static String existingInterviewerName = "Aaron";
    static String existingInterviewerLastName = "Rios";
    static String existingInterviewerEmail =  "aaron@mail.com";

    @BeforeEach
    public void setUp() throws Exception {
        Interviewer.data = new ArrayList<>();
        Interviewer.data.add(new Interviewer(
                existingInterviewerName,
                existingInterviewerLastName,
                existingInterviewerEmail,
                true
        ));
    }

  /*  @Test
    public void testAddInterviewer() {
      /*  String input = "Aaron\nRios\naaron@mail.com\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.addInterviewer();

        Interviewer interviewer = Interviewer.getByEmail("aaron@mail.com");

        Assertions.assertNotNull(interviewer);
        Assertions.assertEquals("Aaron", interviewer.getName());
        Assertions.assertEquals("Rios", interviewer.getLastName());
        Assertions.assertEquals("aaron@mail.com", interviewer.getEmail());
        Assertions.assertTrue(interviewer.getActive());
    }*/
}