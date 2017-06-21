@Specific
Feature: Verify Lab Physician

Background: 
 Given enter easytox url for Lab Physician
  And enter username as "username" for Lab Physician
	And enter password as "password" for Lab Physician
	Then user click on "Login" button for Lab Physician
	
	Scenario: Verify adding a new Physician
  When Click on Setting icon -> Select the "Physician" 
  Then Physician List page should be open
  
  When Click on "+" icon beside the Search Box in Physician List page
  Then "Add Physician" screen should be displayed to enter details
  
  #When Enter all the information in the screen and click Submit
  #And New Physician is created successfully
  Then Close the Lab Physician browser
  
  
  Scenario Outline: Verify updating a physician
  When Click on Setting icon -> Select the "Physician" 
  Then Physician List page should be open
  
  When Click Edit icon for an existing physician
  And Update Physician screen is displayed
  Then Verify User Information should be locked for editing
  
  When Make changes for "<First Name>" and "<Medical Degree>" in Update Physician page -> click Update button
  And Updated "<First Name>" and "<Medical Degree>" should be reflected
  Then Close the Lab Physician browser
  Examples:
  |First Name|Medical Degree|
  |Tom|Graduate|
  
  Scenario Outline: Verify the Search Results
  When Click on Setting icon -> Select the "Physician" 
  Then Physician List page should be open
  
  When Enter any search criteria as "<SearchCriteria>" in the Lab Physician List
  And Matching records with "<SearchCriteria>" should be displayed in the Lab Physician List
  Then Close the Lab Physician browser
  Examples:
  |SearchCriteria|
  |hellophy|
  
  Scenario Outline: Verify Number of records displayed
  When Click on Setting icon -> Select the "Physician" 
  Then Physician List page should be open
  
  When Verify the default number of records displayed in Lab Physician List
  And Default number "10" should be displayed in Lab Physician List
  And Click on dropdown that shows no of records to be displayed on the Lab Physician List
  And Select the "<options>" and corresponding records to be displayed in Lab Physician List 
  Then Close the Lab Physician browser
  Examples:
  |options|
  |25|
  
  Scenario: Verify data sorting
  When Click on Setting icon -> Select the "Physician" 
  Then Physician List page should be open
  
  When Click on "^" Up arrow icon on Physician List 'Username' column
  Then Records should be displayed based on the ascending order in the Physician List 'Username'
  
  When Click on "˅" Down arrow icon on Physician List 'Username' column
  Then Records should be displayed based on the desecending order in the Physician List 'Username'
  
  When Click on "^" Up arrow icon on Physician List 'Name' column
  Then Records should be displayed based on the ascending order in the Physician List 'Name'
  
  When Click on "˅" Down arrow icon on Physician List 'Name' column
  Then Records should be displayed based on the desecending order in the Physician List 'Name'
  
  When Click on "^" Up arrow icon on Physician List 'Portal Access' column
  Then Records should be displayed based on the ascending order in the Physician List 'Portal Access'
  
  When Click on "˅" Down arrow icon on Physician List 'Portal Access' column
  Then Records should be displayed based on the desecending order in the Physician List 'Portal Access'
  
   When Click on "^" Up arrow icon on Physician List 'Medical Degree' column
  Then Records should be displayed based on the ascending order in the Physician List 'Medical Degree'
  
  When Click on "˅" Down arrow icon on Physician List 'Medical Degree' column
  Then Records should be displayed based on the desecending order in the Physician List 'Medical Degree'
  
  When Click on "^" Up arrow icon on Physician List 'Salutation' column
  Then Records should be displayed based on the ascending order in the Physician List 'Salutation'
  
  When Click on "˅" Down arrow icon on Physician List 'Salutation' column
  Then Records should be displayed based on the desecending order in the Physician List 'Salutation'
  
  When Click on "^" Up arrow icon on Physician List 'Locations' column
  Then Records should be displayed based on the ascending order in the Physician List 'Locations'
  
  When Click on "˅" Down arrow icon on Physician List 'Locations' column
  And Records should be displayed based on the desecending order in the Physician List 'Locations'
  Then Close the Lab Physician browser
  
  Scenario: Verify the page navigation
  When Click on Setting icon -> Select the "Physician" 
  Then Physician List page should be open
  
  When Navigate back and forth by selecting page numbers -> Should navigate to selected Physician List page
  And A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the Physician List
  Then Close the Lab Physician browser
  
  
  
 