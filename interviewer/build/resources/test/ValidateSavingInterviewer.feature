Feature: Interviewer Saving

  Scenario: Saving an interviewer
    Given I have an interviewer with name "Aaron", last name "Rios", email "aaron@mail.com", and active status
    When I save the interviewer with updated information: name "Updated", last name "LastName", email "updated@mail.com", and inactive status
    Then the interviewer name should be "Updated"
    And the interviewer last name should be "LastName"
    And the interviewer email should be "updated@mail.com"
    And the interviewer should be inactive
    And the interviewer should be added to the list