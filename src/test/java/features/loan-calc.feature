Feature: UI test for Mortgage Loan calculator

  Background:
    Given Open browser with selected env
    And Go to uri: "private/credit/loans/home?language=ENG"
    Then Accept cookies and terms

  Scenario: Check Monthly payment and maximum possible loan amount calculation
    When set total monthly income = 1000
    And click on ‹I have children (dependants) in family› btn
    And choose 2 dependants btn
    And set "loan" amount slider = 45000
    And set "term" amount slider = 132
    Then calculation result equal to:
      | monthlyPayment | 386   |
      | maxLoanAmount  | 49739 |