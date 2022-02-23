Feature: Hotel CodersLab new account

  Scenario Outline: New account creation
    Given user is on the Testlab Hotel website
    When click SignIn button
    And insert "<email>" addres and click Create an account button
    And insert "<name>" in First name box and insert "<surname>" in Last name box and insert "<password>" in Password box and click Register button
    Then new account should be created and account page displayed

    Examples:
    |name   |surname  |password |email      |
    |Jacek  |Bochenek |numiko   |ddd@mail.pl|
    |Werka  |Bioderka |zxdfg    |ppp@mail.pl|
    |Karol  |Niemiec  |hawk11   |kkk@mail.pl|