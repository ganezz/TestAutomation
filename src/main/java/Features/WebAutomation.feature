Feature: Automating Web Elements concepts in Selenium

  Background: Run in every cases find
    Given Print the statement count of the Scenarios

  Scenario: Data Driven from excel
    Given find the excel sheet
    When find the values in sheet as "Login" , columnname in "Records" and rowname "username"
    Then print the elements in row

  Scenario:  ScreeenShot of the Particular element
    Given Open the Url "https://40.76.4.240:9095/AppzillonAdmin/" in "chrome"
    When find the element in the page
    Then Take a screen shot and save as "elementScr.png"

  Scenario: Windows naigation exercise
    Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
    When Open new window
    Then Navigate to the New window
    And Close the Old window

  @reporting
  Scenario: Working with multiple windows
    Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
    When Open new window
    Then Navigate to the New window
    And Choose About Us from the About dropdown
    Then Print the total windows opened

  @ignore
  Scenario: Change the Data of Birth in Appzillon Admin Page
    Given Open the Url "https://40.83.138.65:9095/AppzillonAdmin/" in "chrome"
    When In Login give username as "admin" and password as "admin" and click login button
    Then Click the Staff Maintenance in Bank Parameter drop down
    And Give the user id as "sri" and click the search button
    When Click the table displaying content in user iD column
    And in following screen click the unlock button and click the Dateof Birth field
    Then Choose the year as "1999" and month as "Sep" and Date as "13"
    And Click the save button


  @ignore
  Scenario: Authorise the user in Appzillon Admin Page
    Given Open the Url "https://40.83.138.65:9095/AppzillonAdmin/" in "chrome"
    When In Login give username as "adminauth" and password as "adminauth" and click login button
    Then Click the Staff Maintenance in Bank Parameter drop down
    And Give the user id as "sri" and click the search button
    When Click the table displaying content in user iD column
    Then Authorise the user
    And Click the save button

  Scenario: Create new Legal Entity in Appzillon admin