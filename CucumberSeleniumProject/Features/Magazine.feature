Feature: Magazine Page

	Scenario: Search for any destination on Magazine by using the search bar
		Given user is in "room5.trivago.com" page
		When user enters any search keyword on search bar			
		And user presses "enter key"
		Then user should be redirected to search results page
		
	Scenario: Fill in the contact form and send it
		Given user navigates to "room5.trivago.com" page
		When user clicks on "Contact" link in the footer
		Then new tab is opened
		When user fills the contact form and submits it
		Then message "Message Sent Successfully!" should be displayed
		
	Scenario: Subscribe to the Newsletter
		Given user enters "room5.trivago.com" page
		When user enters email address in newsletter subscription textbox
		And user clicks on "Inspire me" button
		Then Message "You are now checked-in!" should be displayed