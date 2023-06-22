package org.bedu.java.backend.test.interviewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InterviewerTest {
    static String existingInterviewerName = "First";
    static String existingInterviewerLastName = "User";
    static String existingInterviewerEmail =  "first@email.com";

    @BeforeEach
    public void setUp() throws Exception {
        Interviewer.data = new ArrayList<>();

        // We insert a user for testing delete and save
        Interviewer.data.add(new Interviewer(
                existingInterviewerName,
                existingInterviewerLastName,
                existingInterviewerEmail,
                true
        ));
    }

    @Test
    @DisplayName("Test fort adding interviewer")
    void add() {
        Interviewer interviewer = new Interviewer(
                "Test",
                "User",
                "any@email.com",
                true
        );

        interviewer.add();

        int expectedId = Interviewer.data.size();
        assertEquals(
                expectedId,
                interviewer.id,
                "Interviewer ID should be the new List's size"
        );
    }

    @Test
    @DisplayName("Testin can save")
    void save() {
        Interviewer interviewer = new Interviewer(
                "Test",
                "User",
                "test@example.com",
                true
        );

        interviewer.save("Updated", "LastName", "updated@example.com", false);

        assertEquals(
                "Updated",
                interviewer.name,
                "El nombre del entrevistador no coincide"
        );
        assertEquals(
                "LastName",
                interviewer.lastName,
                "El apellido del entrevistador no coincide"
        );
        assertEquals(
                "updated@example.com",
                interviewer.email,
                "El email del entrevistador no coincide"
        );
        assertFalse(
                interviewer.isActive,
                "El estado activo del entrevistador no coincide"
        );
        assertTrue(
                Interviewer.data.contains(interviewer),
                "El entrevistador no se agregó correctamente a la lista"
        );
    }

    @Test
    @DisplayName("Test find interviewer by mail")
    void getByEmail() {
        Interviewer result = Interviewer.getByEmail(existingInterviewerEmail);

        assertNotNull(result, "Interviewer should be found");
        assertEquals(
                existingInterviewerName,
                result.name,
                "Unexpected Interviewer Name"
        );
        assertEquals(
                existingInterviewerLastName,
                result.lastName,
                "Unexpected Interviewer Last Name"
        );
    }
    @Test
    @DisplayName("Can delete")
    void testDelete(){
        Interviewer interviewer = new Interviewer(
                "Test",
                "User",
                "test@example.com",
                true
        );
        interviewer.save("Updated", "LastName", "updated@example.com", false);
        interviewer.getByEmail("updated@example.com");
        interviewer.delete();

    }
    @Test
    @DisplayName(" can set to string")
    void testToString() {
        String nonExistingEmail = "nonexisting@email.com";

        Interviewer result = Interviewer.getByEmail(nonExistingEmail);

        assertNull(result, "Interviewer should not be found");
    }

    @Test
    @DisplayName("Prueba por No existe email")
    public void getByNonExistingEmail() {
        String nonExistingEmail = "nonexisting@email.com";

        Interviewer result = Interviewer.getByEmail(nonExistingEmail);

        assertNull(result, "Interviewer should not be found");
    }
}