Feature: User Role - live Guru 

@Register_user 
Scenario: TC 01 Register Success To System 
	Given Open user homepage 
	When I click on Account menu 
	And I choose "Register" link at Account menu at header menu 
	And Input to FirstName textbox
	And Input to LastName textbox 
	And Input to Email textbox
	And Input to Password textbox 
	And Input to Confirm Password textbox 
	And I click to Register button 
	Then Verify display message "Thank you for registering with Main Website Store." 
	
@Login_success 
Scenario: TC 02 Login Success To System
	Given I click on Account menu
	And  I choose "Log Out" link at Account menu at header menu 
	When I click on Account menu 
	And I choose "Log In" link at Account menu at header menu
	And Input to Email textbox at Login page 
	And Input to Password textbox at Login page 
	And Click to Login button 
	