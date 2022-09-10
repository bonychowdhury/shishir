Feature: This is a Costco login functionality

@sub
Scenario: Verify Costco User login 
Given Launch Costco Application1 URL
Then Click on Signin link
Then Enter Email Address
Then Enter Password
When Click on Sign in button
Then Verify member login sucessfully