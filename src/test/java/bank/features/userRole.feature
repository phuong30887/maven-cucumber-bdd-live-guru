Feature: User Role - live Guru 

Scenario: TC 01 Register Success To System 
# Open LiveGuru99 site
	Given Open user homepage
	When I click on Acount menu 
	And I choose Register link 
	And Input to FirstName textbox 
	And Input to LastName textbox 
	And Input to Email textbox 
	And Input to Password textbox 
	And Input to Confirm Password textbox 
	And I click to Register button 
	Then Verify display message 'Thank you for registering with Main Website Store.'