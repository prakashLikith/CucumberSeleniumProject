$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Magazine.feature");
formatter.feature({
  "line": 1,
  "name": "Magazine Page",
  "description": "",
  "id": "magazine-page",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Search for any destination on Magazine by using the search bar",
  "description": "",
  "id": "magazine-page;search-for-any-destination-on-magazine-by-using-the-search-bar",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is in \"room5.trivago.com\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters any search keyword on search bar",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user presses \"enter key\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user should be redirected to search results page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "room5.trivago.com",
      "offset": 12
    }
  ],
  "location": "magazineSearch.user_is_in_page(String)"
});
formatter.result({
  "duration": 21701427200,
  "status": "passed"
});
formatter.match({
  "location": "magazineSearch.user_enters_any_search_keyword_on_search_bar()"
});
formatter.result({
  "duration": 3979555000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "enter key",
      "offset": 14
    }
  ],
  "location": "magazineSearch.user_presses(String)"
});
formatter.result({
  "duration": 219093700,
  "status": "passed"
});
formatter.match({
  "location": "magazineSearch.user_should_be_redirected_to_search_results_page()"
});
formatter.result({
  "duration": 6441182900,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Fill in the contact form and send it",
  "description": "",
  "id": "magazine-page;fill-in-the-contact-form-and-send-it",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "user navigates to \"room5.trivago.com\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "user clicks on \"Contact\" link in the footer",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "new tab is opened",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user fills the contact form and submits it",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "message \"Message Sent Successfully!\" should be displayed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "room5.trivago.com",
      "offset": 19
    }
  ],
  "location": "fillContactForm.user_navigates_to_page(String)"
});
formatter.result({
  "duration": 10279116000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Contact",
      "offset": 16
    }
  ],
  "location": "fillContactForm.user_clicks_on_link_in_the_footer(String)"
});
formatter.result({
  "duration": 1140096300,
  "status": "passed"
});
formatter.match({
  "location": "fillContactForm.new_tab_is_opened()"
});
formatter.result({
  "duration": 3145801100,
  "status": "passed"
});
formatter.match({
  "location": "fillContactForm.user_fills_the_contact_form_and_submits_it()"
});
formatter.result({
  "duration": 2086733600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Message Sent Successfully!",
      "offset": 9
    }
  ],
  "location": "fillContactForm.message_should_be_displayed(String)"
});
formatter.result({
  "duration": 3644585100,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Subscribe to the Newsletter",
  "description": "",
  "id": "magazine-page;subscribe-to-the-newsletter",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "user enters \"room5.trivago.com\" page",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "user enters email address in newsletter subscription textbox",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "user clicks on \"Inspire me\" button",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Message \"You are now checked-in!\" should be displayed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "room5.trivago.com",
      "offset": 13
    }
  ],
  "location": "subscribeToNewsletter.user_enters_page(String)"
});
formatter.result({
  "duration": 10807487900,
  "status": "passed"
});
formatter.match({
  "location": "subscribeToNewsletter.user_enters_email_address_in_newsletter_subscription_textbox()"
});
formatter.result({
  "duration": 890749600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Inspire me",
      "offset": 16
    }
  ],
  "location": "subscribeToNewsletter.user_clicks_on_button(String)"
});
formatter.result({
  "duration": 234423000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "You are now checked-in!",
      "offset": 9
    }
  ],
  "location": "subscribeToNewsletter.message_should_be_displayed(String)"
});
formatter.result({
  "duration": 3601351600,
  "status": "passed"
});
});