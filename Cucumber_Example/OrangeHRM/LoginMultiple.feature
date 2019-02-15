Feature: OrangeHRM application Login Functionality test
  Scenario Outline: LoginTest
Given Open firefox Browser and navigate to OrangeHRM application
When User enters valid "<username>" and "<password>" and click on signin button
Then user should be able to successfully login to the application and close

    Examples: 
      | username  | password | 
      | roott     | Livetech7.30 | 
      | hello     | hello | 