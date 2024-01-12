@All
Feature: Hydra care application

  Scenario Outline: Login Hydra care application
    Given I login to hydracare using "<username>" and "<password>"
    #Then I verify home screen

    Examples: 
      | username  | password  |
      | hydracare | Test@1234 |
