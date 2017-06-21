@Specific
Feature: Verify Insurance Company.

Background: 
 Given user enter easytox url
  And enter username as "username"
	And enter password as "password"
	And user click on "Login" button 

  Scenario Outline: Verify adding a new insurance company.
  When Select Settings ->Insurance Company
  Then Insurance Company List screen is displayed
  
  When Click Add Insurance Company "+" icon
  Then 'Add Insurance Company' page should be displayed
  
	When Enter CompanyCodeInfo as "<Company Code>"
  And Enter CompanyNameInfo as "<CompanyName>"
  And Entered "<Address1>" Info 
  And Enter "<Address2>" Info 
  And Enter ZipcodeInfo as "<Zipcode>"
  And Enter CityInfo as "<City>"
  And Enter StateInfo as "<State>"
  And  "<Phone1>" Info enter
  And "<Phone2>" Info  entered 
  And Enter FaxInfo as "<Fax>"
  And Enter EmailInfo as "<Email>"
  And Enter WebsiteInfo as "<Website>"
  And Enter PayerIdInfo as "<PayerId>"
  And Enter AdjusterInfo as "<Adjuster>"
  And Enter StatusInfo as "<Status>"
  And Enter PayNumInfo as "<PayNum>"
  And Click on Submit button
  Then A new insurance company as "<CompanyName>" should be created successfully.
   
  When Click + icon against the new "<Company Code>" and "<CompanyName>"insurance company -> Data should be correctly populated
  Then closes the browser
  Examples:
    |Company Code|CompanyName|Address1|Address2|Zipcode|City|State|Phone1|Phone2|Fax|Email|Website|PayerId|Adjuster|Status|PayNum|
    |123|Nationwide|5742|Bulding 5	|43220|Dublin|AZ|4566789871|1234567893|3456782342|abc@gmail.com|http://abc.com|JH56|John|Active|345|
    |456|Metlife|786 park rd| suite 5	|43218|Columbus|OH|6786789871|6724534593|4566782342|xyz@gmail.com|http://xyz.com|2256|Mark|Inactive|22|
	
	#Scenario 2
	
	Scenario Outline: Verify updating an insurance company
	When Select Settings ->Insurance Company
  Then Insurance Company List screen is displayed
  
  When Click Edit icon for a Insurance Company
  Then 'Update Insurance Company' page should be displayed
  
  When Make changes for "<Company Code>" and "<CompanyName>" -> click Update button
  Then Insurance Company "<CompanyName>" should be updated successfully
  
  When Click + icon against the updated "<Company Code>" "<CompanyName>" insurance company -> Changes should be reflected
  Then closes the browser
  
  Examples:
  |Company Code|CompanyName|
  |500|UnitedHealth|
  
  #Scenario 3
  
  Scenario: Verify deleting an insurance company
  When Select Settings ->Insurance Company
  Then Insurance Company List screen is displayed
  
  When Click Edit icon for a Insurance Company
  Then 'Update Insurance Company' page should be displayed
  
  When Click Delete button -> Confirmation message box is displayed
  Then Click "Cancel" on confirmation message box -> Insurance company not deleted
  
  When Click Delete button -> Confirmation message box is displayed
  And Click "OK" on confirmation message box -> Insurance company deleted
  Then closes the browser
  
  #Scenario 4
  
  Scenario Outline: Verify the Search Results
  When Select Settings ->Insurance Company
  Then Insurance Company List screen is displayed
  
  When Enter any search criteria as "<Search>" in search box
  And Matching records with "<Search>" data should be displayed in the Insurance Company List
  Then closes the browser
  
  Examples:
  |Search|
  |Cigna|
  
  #Scenario 5
  
  Scenario Outline: Verify Number of records displayed per page
   When Select Settings ->Insurance Company
  Then Insurance Company List screen is displayed
  
  When Verify the default number of records displayed
  Then Default number "10" should be displayed in the dropdown box
  
  When Click on dropdown that shows no of records to be displayed on the page
  And Select the "<options>" and corresponding records to be displayed
  Then closes the browser
  Examples:
  |options|
  |25|
  
  #Scenario 6
  
  Scenario: Verify data sorting 
  When Select Settings ->Insurance Company
  Then Insurance Company List screen is displayed
  
  When Click on Up arrow next to Company Code
  Then Records should be sorted ascending order in Company Code column
  
   When Click on Down arrow next to Company Code
   Then Records should be sorted descending order in Company Code column
  
  When Click on Up arrow next to Company Name
  Then Records should be sorted ascending order in Company Name column
  
   When Click on Down arrow next to Company Name
   Then Records should be sorted descending order in Company Name column

  When Click on Up arrow next to Contact Number
  Then Records should be sorted ascending order in Contact Number column
  
   When Click on Down arrow next to Contact Number 
   Then Records should be sorted descending order in Contact Number column
   
   When Click on Up arrow next to Fax
  Then Records should be sorted ascending order in Fax column
  
   When Click on Down arrow next to Fax 
   Then Records should be sorted descending order in Fax column
  
  When Click on Up arrow next to Email
  Then Records should be sorted ascending order in Email column
  
   When Click on Down arrow next to Email 
   Then Records should be sorted descending order in Email column
   
   When Click on Up arrow next to Website
  Then Records should be sorted ascending order in Website column
  
   When Click on Down arrow next to Website 
   And Records should be sorted descending order in Website column
   Then closes the browser
  
  #Scenario 7
  
  Scenario: Verify the page navigation
  When Select Settings ->Insurance Company
  Then Insurance Company List screen is displayed
  
  When Navigate back and forth by selecting page numbers -> Should navigate to selected page
  And A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the list
  Then closes the browser
  
	