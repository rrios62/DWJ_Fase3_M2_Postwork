Feature: Interviewer Adding

  Scenario: Adding an interviewer
    Given I have an interviewer with name "Aaron", last name "Rios", email "aaron@mail.com", and active status
    When I add the interviewer
    Then the interviewer ID should be the new List's size


