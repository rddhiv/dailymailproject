Feature: Feature to test Sports Link and Features functionality

  Scenario: Click on the Webpageand Navigate to Sports Tab and Test the sports content in webpage
    Given User Click on the Webpage "https://www.dailymail.co.uk/home/index.html"
    Then User can able to view the current date and time at the corner in the webpage
    And User can able to view Sports tab and click on it and it Navigate to the Sport menu and Click Football tan and verify the color of the Tab
    Then User should click on the Football page first hyperlink and content should get displayed
    Then User should Go to the gallery and Click on gallery image
    And Gallery Image should display verify previous and next button with proper image navigation
    When User should Click on the Facebook embedded image and FB model dialog should appear  
     Then User should click on video embedded within the article and click the full screen button 
    And ensure video can be viewed in full screen and minimized 
    Then Navigate to the bottom right of the article page to the Premier League Table section 
    And  exhibit the points or positions from the Premier league table 
    
    