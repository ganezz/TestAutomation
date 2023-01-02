Feature: Practice on Rahul shetty https://rahulshettyacademy.com/AutomationPractice/

  Scenario: verify Radio button
    Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
    When Select the Radio button
    And Check the button is clicked
    Then Select the differnt buttons

    Scenario: Verify autosuggestion
      Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
      When Input the suggest text in country name as "ind"
      Then Select the value of "india"

    Scenario: Verify the drop down
      Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
      When Select the differnt elements

    Scenario: Verify the checkbox
      Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
      When Select the all checkboxes
      Then Deselect one box

    Scenario: Handling new Browser window
      Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
      Then Open another child window from the URL "https://rahulshettyacademy.com/#/documents-request"

    Scenario: Alert Handling
      Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
      When Open alert box and get text from it
      Then Open promt box and put text on it then accept

    Scenario: Fields Visibility checking
      Given Open the Url "https://rahulshettyacademy.com/AutomationPractice/" in "chrome"
      When Check field is visible , if visible then hide it else Invisible then show it

