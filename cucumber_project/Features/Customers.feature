Feature: Customers

 Background: Steps for login
 		Given User launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters emails as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard
  
@sanity   
Scenario: Add a new Customer 
 		When User click on customers menu
    And click on customers Menu item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

@regression    
Scenario: Search a customer by email id
    When User click on customers menu
    And click on customers Menu item
    And Enter customer email id
    When Click on search button
    And close browser

@regression			
Scenario: Search customer by Name	
    When User click on customers menu
    And click on customers Menu item
    And Enter customer first name
    And Enter customer last name
		When Click on search button
    And close browser    
    	