Feature: Interviewer Finding

Scenario: Finding an interviewer by email
Given I have an interviewer with name "Aaron", last name "Rios", email "aaron@mail.com", and active status
And I search for the interviewer by email "aaron@mail.com"
Then the interviewer name should be "Aaron"
And the interviewer last name should be "Rios"

Scenario: Finding a non-existing interviewer
Given I search for an interviewer with non-existing email "nonexisting@example.com"
Then the interviewer should not exist
