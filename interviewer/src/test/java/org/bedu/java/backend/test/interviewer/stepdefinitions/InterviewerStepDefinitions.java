package org.bedu.java.backend.test.interviewer.stepdefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.bedu.java.backend.test.interviewer.Interviewer;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InterviewerStepDefinitions {
    private static Interviewer interviewer;
    private String updatedEmail;
    private int expectedId;
    private Interviewer foundInterviewer;

    @BeforeAll
    public static void setup() {
        interviewer.data = new ArrayList<>();
    }

    //Interviewer comun
    @Given("I have an interviewer with name {string}, last name {string}, email {string}, and active status")
    public void createInterviewer(String name, String lastName, String email) {
        interviewer = new Interviewer(name, lastName, email, true);
    }
    //Interviewer finding
    @Given("I search for an interviewer with non-existing email {string}")
    public void searchNonExistingInterviewer(String nonExistingEmail) {
        foundInterviewer = Interviewer.getByEmail(nonExistingEmail);
    }

    //Interviewer Adding
    @When("I add the interviewer")
    public void addInterviewer() {
        interviewer.add();
        expectedId = Interviewer.data.size();
    }
    //Interviewer deleting
    @When("I save the interviewer with updated information: name {string}, last name {string}, email {string}, and inactive status")
    public void saveInterviewer(String updatedName, String updatedLastName, String updatedEmail) {
        this.updatedEmail = updatedEmail;
        boolean updatedIsActive = false;

        interviewer.save(updatedName, updatedLastName, updatedEmail, updatedIsActive);
    }

    //Interviewer deleting
    @And("I search for the interviewer by email {string}")
    public void searchInterviewerByEmail(String updatedEmail) {
        foundInterviewer = Interviewer.getByEmail(updatedEmail);
    }
    //Interviewer deleting
    @And("I delete the interviewer")
    public void deleteInterviewer() {
        interviewer.delete();
    }

    //Interviewer Adding
    @Then("the interviewer ID should be the new List's size")
    public void verifyInterviewerId() {
        assertEquals(expectedId, interviewer.id, "Interviewer ID should be the new List's size");
    }

    //Interviewer deleting
    @Then("the interviewer should not exist")
    public void verifyInterviewerDoesNotExist() {
        assertNull(foundInterviewer, "Interviewer should not exist");
    }

    //Interviewer finding
    @And("the interviewer name should be {string}")
    public void verifyInterviewerName(String expectedName) {
        assertEquals(expectedName, interviewer.getName(), "El nombre del entrevistador no coincide");
    }
    //Interviewer finding
    @Then("the interviewer last name should be {string}")
    public void verifyInterviewerLastName(String expectedLastName) {
        assertEquals(expectedLastName, interviewer.getLastName(), "El apellido del entrevistador no coincide");
    }
    @And("the interviewer should be inactive")
    public void verifyInterviewerIsActive() {
        assertFalse(interviewer.isActive, "El estado activo del entrevistador no coincide");
    }
    @And("the interviewer should be added to the list")
    public void verifyInterviewerAddedToList() {
        assertTrue(Interviewer.data.contains(interviewer), "El entrevistador no se agregó correctamente a la lista");
    }

    @Then("the interviewer email should be {string}")
    public void verifyInterviewerEmail(String expectedEmail) {
        assertEquals(expectedEmail, interviewer.getEmail(), "El email del entrevistador no coincide");
    }
}
