Feature: Interviewer Deleting

Scenario: Deleting an interviewer
Given I have an interviewer with name "Aaron", last name "Rios", email "aaron@mail.com", and active status
When I save the interviewer with updated information: name "Updated", last name "LastName", email "update@mail.com", and inactive status
And I search for the interviewer by email "updated@example.com"
And I delete the interviewer
And I search for the interviewer by email "updated@example.com"
Then the interviewer should not exist