Feature: Send message in contact us feature

  Scenario: Sending message
    Given open websitesendmsg to check
    When sign sendmsg
    Then click sendmsg