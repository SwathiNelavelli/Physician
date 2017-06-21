@Specific
Feature: Verify Testing Profile

Background: 
 Given enter easytox url for Testing Profile
  And enter username as "username" for Testing Profile
	And enter password as "password" for Testing Profile
	Then user click on "Login" button for Testing Profile
  
  Scenario Outline: Verify the Search Results
  When Click on Library icon -> Select the "Testing Profile" 
  Then Testing Profile page should be open
  
  When Enter any search criteria as "<SearchCriteria>" 
  And Matching records with "<SearchCriteria>" should be displayed in the Test Profile
  Then close the Test Profile browser
  Examples:
  |SearchCriteria|
  |Profile1|
  
  Scenario: Verify Adding a new profile
  When Click on Library icon -> Select the "Testing Profile" 
  Then Testing Profile page should be open
  
  When Click on "+" icon beside the Search Box in Profile page
  And "Add Profile" screen should be displayed for Profile page
  Then close the Test Profile browser
  
  Scenario Outline: Verify Number of records displayed
  When Click on Library icon -> Select the "Testing Profile" 
  Then Testing Profile page should be open
  
  When Verify the default number of records displayed in Profile Page
  And Default number "10" should be displayed in Profile Page
  And Click on dropdown that shows no of records to be displayed on the Profile page
  And Select the "<options>" and corresponding records to be displayed in Profile page 
  Then close the Test Profile browser
  Examples:
  |options|
  |20|
  
  Scenario: Verify data sorting
  When Click on Library icon -> Select the "Testing Profile" 
  Then Testing Profile page should be open
  
  When Click on "^" Up arrow icon on Profile Name column
  Then Records should be displayed based on the ascending order of the Profile Name
  
  When Click on "˅" Down arrow icon on Profile Name column
  And Records should be displayed based on the desecending order of the Profile Name
  Then close the Test Profile browser
  
  Scenario: Verify Edit Icon under Action Column
  When Click on Library icon -> Select the "Testing Profile" 
  Then Testing Profile page should be open
  
  When Click on Edit under Action Column in Profile page
  And "Edit Profile" window should be displayed for Profile page
  Then close the Test Profile browser
  
  Scenario: Verify the pagination
  When Click on Library icon -> Select the "Testing Profile" 
  Then Testing Profile page should be open
  
  When Navigate back and forth by selecting page numbers -> Should navigate to selected Profile page
  And A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the Profile list
  Then close the Test Profile browser
  
  
  
  
  
  
   
  
  
  