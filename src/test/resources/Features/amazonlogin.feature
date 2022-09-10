Feature: This is an amazon login functionality

@bona
Scenario: Verify user Amazon login
Given Launch Application Amazon URL
When Click on Amazon Login link
When Enter Amazon email
When click on continue
When Enter Amazon Password
When Click on Amazon Login button
Then Verify Amazon login successfully
