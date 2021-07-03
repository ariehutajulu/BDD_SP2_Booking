Feature: Send invalidmessage in contact us feature

  Scenario: Sending invmessage
    Given open websitesendinvmsg to check
    When sign sendinvmsg
    Then click sendinvmsg