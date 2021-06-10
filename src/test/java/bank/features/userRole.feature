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
	And I choose "Log Out" link at Account menu at header menu 
	When I click on Account menu 
	And I choose "Log In" link at Account menu at header menu 
	And Input to Email textbox at Login page 
	And Input to Password textbox at Login page 
	And Click to Login button 
	#	Then I see My Dashboard page
	#	And I see my full name is displayed
	
#@Verify_cost_of_product 
#Scenario: TC 03 Verify Cost Of Product In List Page Equals to Details Page 
#	When I click to Mobile link at header menu 
#	And I get cost of "Samsung Galaxy" at product listing page 
#	And I click to product link "Samsung Galaxy" 
#	Then I see the cost at product detail page equals to cost at product listing page 
#	
#@Verify_Discount_Coupon_Works_Correctly 
#Scenario: TC 04 Verify Discount Coupon Works Correctly 
#	When I click to Add to card button 
#	And Input "GURU50" to Discount codes textbox 
#	And Click to Apply button 
#	Then I see the success message Coupon code "GURU50" was applied. displayed 
#	And I see the discount value is "-$6.50" 
#	And I see the grand total value is discounted "-$6.50" 
#	
#@Verify_Can_Not_Add_More_Than_500_Items_To_Cart 
#Scenario: TC 05 Verify Can Not Add More Than 500 Items To Cart 
#	When  I input "501" to quantity textbox 
#	And   I click to Update button 
#	Then   I see the error message "Some of the products cannot be ordered in requested quantity." 
#	And    I see the message "* The maximum quantity allowed for purchase is 500." 
#	When I click to Empty Cart link 
#	Then I see the empty message "SHOPPING CART IS EMPTY" at Shopping Cart page 
#	And I see the no items message "You have no items in your shopping cart." at Shopping Cart page 
	
@Compare_Two_Products 
Scenario: TC 06 Compare Two Products 
	When I click to Mobile link at header menu 
	And I click to Add To Compare link of product "Sony Xperia" 
	Then I see the message the product "Sony Xperia" has been added to comparison list 
	When I click to Add To Compare link of product "IPhone" 
	Then I see the message the product "IPhone" has been added to comparison list 
	When I click to Compare button 
	Then I see the title of page is "Compare Products" 
	And I see the product name "Sony Xperia" is displayed at compare products table 
	And I see the product name "IPhone" is displayed at compare products table 
	And I close the Compare Products window 
	
	
	
	