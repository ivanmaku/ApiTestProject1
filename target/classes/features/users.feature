Feature: Users
  Scenario: Creating a user
    Given user has proper authorization "Bearer 106b8f21995c73c87f315a314df2a751097151c10820b7bf28bed937c94a191f"
    When user provides body information
    Then user gets response of created user