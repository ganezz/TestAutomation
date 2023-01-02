Feature: Negative Test Case of Login


  Scenario Outline: Validating Login Screen postive & negative scenario
    Given I launch "yahoo" APP
    When I tab the Already user login
    Then Login page will open
    And i give the login id as  "<email>" and enter login button
    Then Validate Authentication
    Examples:
      | email                |
      | sriganesh.f@yahoo.com |
      | sriganesh.d@yahoo.com |


    Scenario: If the Email is correct then Proceed to Password page , is incorrect then Show the error
      And If Email is correct then give password as "Ammu@1654"
      Then Click the Login button

  @ignore
  Scenario: Sending Mail from Yahoo pre : User Account must login beforexecution
    Given I launch "yahoo" APP
    When I tap the Compose button
    Then Compose page will open
    When Tap the To and give value as "sganesh.d@yahoo.com"
    And Tap the Subject and give value as "Automated Mail from Sri Ganesh"
    When Tap the Body Section and give value as " Greetings , This mail is send from Sri Ganesh Using Cucumber & Appium Framework"
    And Tap the send button

  @ignore
  Scenario: Scrolling Feature
    Given I launch "APIdemo" APP
    When I Tap the Views
    And Scroll down
    And Select Text
    Then Select EditText
    Then Longpress on Edit Field

