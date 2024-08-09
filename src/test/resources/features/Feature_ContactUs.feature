
Feature: ContactUs feature funtionality
  

  @Regression 
  Scenario: My Info ContactUs Details Functionality
   Given   User opens browser
    When    User launches URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And     User enter Email as "Admin" and Password as "admin123"
    And     User clicks on Login button
    Then    Page Home page Title should be "OrangeHRM"
    And     User clicks on MyInfo option
    And     User clicks on Contact details option
    Then    User can view contact details 
    And     User enters Street1 details
    And     User enters State details
    And     User enters Zipcode Deatis
    And     User selects country from dropdown
    And     User enters mobile number
    Then    User clicks on save button

 