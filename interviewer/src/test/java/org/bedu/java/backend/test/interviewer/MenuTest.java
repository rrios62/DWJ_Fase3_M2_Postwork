package org.bedu.java.backend.test.interviewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void testModifyInterviewer() {
        // Preparación de datos
        Interviewer interviewer = new Interviewer("John", "Doe", "john@example.com", true);
        interviewer.add();

        // Simulación de la entrada del usuario
        String inputEmail = "john@example.com";
        String newName = "John";
        String newLastName = "Smith";
        String newEmail = "john.smith@example.com";
        String isActiveInput = "2"; // Entrevistador no activo

        // Simulación del flujo de ejecución
        menu.sc = new ScannerMock(Arrays.asList(inputEmail, newName, newLastName, newEmail, isActiveInput));
        menu.modifyInterviewer();

        // Verificación de resultados
        Interviewer modifiedInterviewer = Interviewer.getByEmail(newEmail);
        Assertions.assertNotNull(modifiedInterviewer);
        Assertions.assertEquals(newName, modifiedInterviewer.getName());
        Assertions.assertEquals(newLastName, modifiedInterviewer.getLastName());
        Assertions.assertEquals(newEmail, modifiedInterviewer.getEmail());
        Assertions.assertFalse(modifiedInterviewer.isActive());
    }

}