Feature: Login

@sanity
  Scenario Outline: Successful login with valid credentials
    Given User launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters emails as "<email>" and password as "<password>"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page title should be "Your store. Login"
    And close browser
    
    Examples:
			|email							 |password|
			|admin@yourstore.com |admin   |
			|admin1@yourstore.com|admin1  |