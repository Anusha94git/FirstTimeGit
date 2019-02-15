Feature: OrangeHRM application login functionality test
Scenario Outline: Login Test
    Given Open firefox Browser and navigate to OrangeHRM application
    When User enters valid "<Username>" and "<Password>" and click on signIn button
    Then User should be able to successfully login to the application and close

    Examples: 
      | Username  | Password |
      | roott     | Livetech7.30 | 
      | hello     | Livetech7.30 | 