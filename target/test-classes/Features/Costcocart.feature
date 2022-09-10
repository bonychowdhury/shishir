Feature: This is a Costcocart functionality
@bon
Scenario: Verify user added item in Costcocart 
Given Launch Costco Application URL
Then Click on HotBuys
Then Click on Vegetable tray
Then Enter Address
Then Click on Start shopping
When Click on Add to cart button
Then Verify item added in Costcocart