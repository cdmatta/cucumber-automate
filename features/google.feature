Feature: Google.com can be accessed

  Scenario: Check google is working
    Given user opens new browser session
    When user opens "http://www.google.com"
    Then the page title is "Google"
