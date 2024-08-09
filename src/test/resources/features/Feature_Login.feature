
Feature: Login Funtionality
Background:
    Given   User opens browser
    When    User launches URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And     User enter Email as "Admin" and Password as "admin123"
    And     User clicks on Login button
    Then    Page Home page Title should be "OrangeHRM"

  @Sanity
  Scenario: Login Functionality
    Then    User checks for dashboard validation as "Dashboard"
    
    
    
  @Sanity
   Scenario Outline:Login with DDT Multiple credentials
    Then    User clicks on Logout
    
     Examples: 
    |Email           | Password|
    |AdminRaj        | admin2345 |
    |Admin           | admin123  |
    
    
   
 
    
    