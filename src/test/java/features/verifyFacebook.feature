Feature: Facebook login page 

#  @displayed
Scenario: Verify login page 
	Given Open facebook application 
	Then Verify email textbox is displayed 
	And Verify password textbox is displayed 
#	And Close application 
	
Scenario: Login with parameter 
#	Given I open My Account page 
	When I input to Username "abc@yahoo.com" 
	And I input to Password "123456" 
	And I click to Login button 
#	Then Close application 
	
Scenario: Login with multiple parameter in a step 
#	Given I open My Account page 
	When I input to Username "abc@yahoo.com" and Password "123456" 
	And I click to Login button 
#	Then Close application 
	
Scenario Outline: Login with parameter from scenario outline 
#	Given I open My Account page 
	When I input to Username and Password 
		|Username|Password|
		|<Username>|<Password>|
	And I click to Login button 
#	Then Close application
	
	Examples:
	|Username|Password|
	|abcOutline@yahoo.com|123456Outline|