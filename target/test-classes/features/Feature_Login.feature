@tag
Feature: Login Funtionality
 

  @tag1
  Scenario: Login Functionality
    Given   User opens browser
    When    User launches URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And     User enter Email as "Admin" and Password as "admin123"
    And     User clicks on Login button
    Then    Page Home page Title should be "OrangeHRM"
    
    