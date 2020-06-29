Feature: : Login into Application
Scenario Outline: Positive scenario Testing
Given Initialize the chrome browser
And Navigate to "http://www.qaclickacademy.com/"
And Click on Login to land on Home Page
When User enter <username> and <password>
Then Verify that user successfully logged In.

Examples:
|username			|password	|
|test99@gmail.com	|123456		|
|test123@gmail.com	|11111		|

