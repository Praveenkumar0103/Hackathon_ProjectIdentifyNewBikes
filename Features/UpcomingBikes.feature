Feature: Navigation to upcoming bikes in Honda

  Scenario: Honda Bikes less than four lakhs
    Given the user navigates to new bikes menu
    And selects the upcoming bikes
    When the user selects the manufacturer as Honda
    And clicks on view more bikes
    Then the honda bikes less than four lakhs gets displayed
